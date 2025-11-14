package com.lsw.onbid.util;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@Slf4j
public class ExternalApiClient {

    private static final String BASE_URL =
            "http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPbctCltrList";

    private String SERVICE_KEY;

    @PostConstruct
    public void loadKey() {
        SERVICE_KEY = System.getenv("ONBID_API_KEY");

        if (SERVICE_KEY == null || SERVICE_KEY.isEmpty()) {
            log.error("❌ 환경변수 ONBID_API_KEY 없음");
        } else {
            log.info("🔑 ONBID API KEY 로딩 성공");
        }
    }

    /** totalCount 조회 */
    public int getTotalCount() {
        try {
            String url = BASE_URL
                    + "?ServiceKey=" + SERVICE_KEY   // ★ 대문자 ServiceKey 필수 ★
                    + "&DPSL_MTD_CD=0001"
                    + "&pageNo=1"
                    + "&numOfRows=1";

            log.info("[API CALL] {}", url);

            JSONObject body = call(url);
            return body.optInt("totalCount", 0);

        } catch (Exception e) {
            log.error("[API totalCount ERROR]", e);
            return 0;
        }
    }

    /** Page 조회 */
    public JSONArray fetchItems(int page, int size) {
        try {
            String url = BASE_URL
                    + "?ServiceKey=" + SERVICE_KEY    // ★ 수정됨
                    + "&DPSL_MTD_CD=0001"
                    + "&pageNo=" + page
                    + "&numOfRows=" + size;

            log.info("[API CALL] {}", url);

            JSONObject body = call(url);

            if (!body.has("items")) return new JSONArray();

            Object items = body.get("items");
            if (items instanceof JSONObject obj) {

                if (obj.get("item") instanceof JSONArray arr)
                    return arr;

                JSONArray arr = new JSONArray();
                arr.put(obj.get("item"));
                return arr;
            }

            return new JSONArray();

        } catch (Exception e) {
            log.error("[API fetchItems ERROR]", e);
            return new JSONArray();
        }
    }

    /** HTTP → XML → JSON 변환 */
    private JSONObject call(String url) throws Exception {
        String xml = request(url);
        JSONObject json = XML.toJSONObject(xml);

        if (!json.has("response")
                || !json.getJSONObject("response").has("body")) {

            log.error("[API ERROR] body 없음. XML={}", xml);
            return new JSONObject();
        }

        return json.getJSONObject("response").getJSONObject("body");
    }

    private String request(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader br;
        if (conn.getResponseCode() == 200)
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        else
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);

        br.close();
        conn.disconnect();
        return sb.toString();
    }
}

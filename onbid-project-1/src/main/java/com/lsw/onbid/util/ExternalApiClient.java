package com.lsw.onbid.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExternalApiClient {

    private static final String BASE_URL =
            "http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPbctCltrList";

    @Value("${onbid.serviceKey}")
    private String SERVICE_KEY;

    /**
     * 전체 개수 조회
     */
    public int getTotalCount() {
        try {
            String url = BASE_URL
                    + "?serviceKey=" + SERVICE_KEY
                    + "&pageNo=1"
                    + "&numOfRows=1"
                    + "&DPSL_MTD_CD=0001"; // 처분방식 코드

            log.info("[API] TOTAL COUNT URL: {}", url);

            String xml = request(url);
            JSONObject json = XML.toJSONObject(xml);

            JSONObject body = json
                    .getJSONObject("response")
                    .getJSONObject("body");

            return body.optInt("totalCount", 0);

        } catch (Exception e) {
            log.error("[API] getTotalCount() 실패", e);
            return 0;
        }
    }

    /**
     * 목록 조회
     */
    public JSONArray fetchItems(int page, int pageSize) {

        try {
            String url = BASE_URL
                    + "?ServiceKey=" + SERVICE_KEY
                    + "&pageNo=" + page
                    + "&numOfRows=" + pageSize
                    + "&DPSL_MTD_CD=0001";

            log.info("[API] LIST URL: {}", url);

            String xml = request(url);
            JSONObject json = XML.toJSONObject(xml);

            JSONObject body = json
                    .getJSONObject("response")
                    .getJSONObject("body");

            if (!body.has("items")) return new JSONArray();

            Object items = body.get("items");

            if (items instanceof JSONObject jo) {
                if (jo.get("item") instanceof JSONArray ja) {
                    return ja;
                } else {
                    JSONArray arr = new JSONArray();
                    arr.put(jo.get("item"));
                    return arr;
                }
            }

            return new JSONArray();

        } catch (Exception e) {
            log.error("[API] fetchItems() 실패", e);
            return new JSONArray();
        }
    }

    /**
     * 공통 HTTP 요청 처리
     */
    private String request(String apiUrl) throws Exception {

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Accept", "*/*");
        
        conn.setConnectTimeout(7000);
        conn.setReadTimeout(7000);

        int responseCode = conn.getResponseCode();
        log.info("[API] 응답 코드: {}", responseCode);

        BufferedReader br;

        if (responseCode == 200) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }

        StringBuilder result = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        br.close();
        conn.disconnect();

        return result.toString();
    }
}

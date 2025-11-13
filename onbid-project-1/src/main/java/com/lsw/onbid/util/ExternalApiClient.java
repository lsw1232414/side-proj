package com.lsw.onbid.util;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class ExternalApiClient {

    @Value("${onbid.api.key}")
    private String serviceKey;

    private static final String BASE_URL =
            "https://openapi.onbid.co.kr/openapi/services/OnbidBidGoodsInfoService/getBidGoodsList";

    /**
     * 온비드 전체 물건 목록 조회 (페이지 단위)
     */
    public JSONArray fetchPage(int pageNo, int rows) {

        try {
            String apiUrl = BASE_URL
                    + "?serviceKey=" + serviceKey
                    + "&numOfRows=" + rows
                    + "&pageNo=" + pageNo
                    + "&DPSL_MTD_CD=0001";   // 매각(0001) — 필수값

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8")
            );

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();

            // XML → JSON 변환
            JSONObject xmlJson = XML.toJSONObject(sb.toString());

            JSONObject response = xmlJson.getJSONObject("response");
            JSONObject body = response.getJSONObject("body");

            if (!body.has("items")) {
                return new JSONArray();
            }

            Object itemsObj = body.getJSONObject("items").get("item");

            if (itemsObj instanceof JSONArray) {
                return (JSONArray) itemsObj;
            } else {
                JSONArray arr = new JSONArray();
                arr.put(itemsObj);
                return arr;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    /**
     * 전체 페이지수 가져오기
     */
    public int getTotalCount() {

        try {
            String apiUrl = BASE_URL
                    + "?serviceKey=" + serviceKey
                    + "&numOfRows=1"
                    + "&pageNo=1"
                    + "&DPSL_MTD_CD=0001";

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8")
            );

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) sb.append(line);

            br.close();

            JSONObject xmlJson = XML.toJSONObject(sb.toString());
            JSONObject response = xmlJson.getJSONObject("response");
            JSONObject body = response.getJSONObject("body");

            return body.getInt("TotalCount");

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

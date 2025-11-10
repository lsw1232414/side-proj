package com.lsw.onbid.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OnbidService {

    @Value("${onbid.api.key}")
    private String SERVICE_KEY;

    public List<Map<String, Object>> fetchOnbidData() {
        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.onbid.co.kr/openapi/services/KamcoPblsalThingInquireSvc/getKamcoPbctCltrList");
            urlBuilder.append("?serviceKey=").append(URLEncoder.encode(SERVICE_KEY, "UTF-8"));
            urlBuilder.append("&pageNo=1");
            urlBuilder.append("&numOfRows=5"); //현재 불러오는 데이터

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");

            BufferedReader rd = (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300)
                    ? new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))
                    : new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) sb.append(line);
            rd.close();
            conn.disconnect();

            JSONObject jsonObj = XML.toJSONObject(sb.toString());
            JSONObject body = jsonObj.getJSONObject("response").getJSONObject("body");
            JSONObject items = body.getJSONObject("items");
            JSONArray itemArray = items.getJSONArray("item");

            for (int i = 0; i < itemArray.length(); i++) {
                JSONObject obj = itemArray.getJSONObject(i);

                Map<String, Object> map = Map.ofEntries(
                	    entry("물건번호", obj.opt("CLTR_NO")),
                	    entry("물건관리번호", obj.opt("CLTR_MNMT_NO")),
                	    entry("물건명", obj.opt("CLTR_NM")),
                	    entry("처분방법", obj.opt("DPSL_MTD_NM")),
                	    entry("카테고리", obj.opt("CTGR_FULL_NM")),
                	    entry("주소", obj.opt("LDNM_ADRS")),
                	    entry("감정가격", obj.opt("APSL_ASES_AVG_AMT")),
                	    entry("최저입찰가", obj.opt("MIN_BID_PRC")),
                	    entry("공고기간", obj.opt("PBCT_BEGN_DTM") + " ~ " + obj.opt("PBCT_CLS_DTM")),
                	    entry("상태", obj.opt("PBCT_CLTR_STAT_NM")),
                	    entry("이력번호목록", obj.opt("CLTR_HSTR_NO"))
                	);
                resultList.add(map);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }
}

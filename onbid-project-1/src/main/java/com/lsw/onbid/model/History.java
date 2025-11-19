package com.lsw.onbid.model;

import org.json.JSONObject;
import lombok.Data;

@Data
public class History {

    private Long id;
    private String cltrNo;
    private String pbctBegnDtm;  // 입찰 시작
    private String pbctClsDtm;   // 입찰 마감
    private Long openPrice;      // 최저입찰가
    private Integer uscbidCnt;   // 유찰 횟수
    private Integer iqryCnt;     // 조회수

    public static History fromJson(JSONObject json) {

        History h = new History();

        // 기본정보
        h.setCltrNo(json.optString("CLTR_NO"));
        h.setPbctBegnDtm(json.optString("PBCT_BEGN_DTM"));
        h.setPbctClsDtm(json.optString("PBCT_CLS_DTM"));

        // ★ 최저입찰가 (API 실제 컬럼명)
        long openPrice = json.optLong("MIN_BID_PRC", 0); // 실제 필드

        // 혹시라도 없는 경우 대비
        if (openPrice == 0) {
            openPrice = json.optLong("PBCT_LWMN_PRC", 0);
        }
        if (openPrice == 0) {
            openPrice = json.optLong("OPEN_PRC", 0);
        }

        h.setOpenPrice(openPrice);

        // 유찰 횟수 / 조회수
        h.setUscbidCnt(json.optInt("USCBD_CNT", 0));
        h.setIqryCnt(json.optInt("IQRY_CNT", 0));

        return h;
    }
}

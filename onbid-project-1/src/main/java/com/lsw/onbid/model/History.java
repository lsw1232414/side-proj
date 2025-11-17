package com.lsw.onbid.model;

import org.json.JSONObject;

import lombok.Data;

@Data
public class History {

    private Long id;
    private String cltrNo;
    private String pbctBegnDtm;  // 입찰 시작
    private String pbctClsDtm;   // 입찰 마감
    private Long openPrice;      // 최저입찰가(하한)
    private Integer uscbidCnt;   // 유찰 횟수
    private Integer iqryCnt;     // 조회수

    public static History fromJson(JSONObject json) {

        History h = new History();

        h.setCltrNo(json.optString("CLTR_NO"));
        h.setPbctBegnDtm(json.optString("PBCT_BEGN_DTM"));
        h.setPbctClsDtm(json.optString("PBCT_CLS_DTM"));
        h.setOpenPrice(json.optLong("OPEN_PRICE_FROM", 0));
        h.setUscbidCnt(json.optInt("USCBD_CNT", 0));
        h.setIqryCnt(json.optInt("IQRY_CNT", 0));

        return h;
    }
}

package com.lsw.onbid.model;

import org.json.JSONObject;
import lombok.Data;

@Data
public class Item {

    private Long id;
    private String cltrMnmtNo;
    private String cltrNo;
    private String cltrNm;
    private String dpslMtdCd;
    private String dpslMtdNm;
    private String ctgrHirkId;
    private String ctgrHirkNm;
    private String ctgrHirkIdMid;
    private String ctgrHirkNmMid;
    private String sido;
    private String dtlAddr;
    private Long goodsPrice;

    public static Item fromJson(JSONObject jo) {

        Item item = new Item();

        item.setCltrMnmtNo(jo.optString("CLTR_MNMT_NO"));
        item.setCltrNo(jo.optString("CLTR_NO"));
        item.setCltrNm(jo.optString("CLTR_NM"));
        item.setDpslMtdCd(jo.optString("DPSL_MTD_CD"));
        item.setDpslMtdNm(jo.optString("DPSL_MTD_NM"));

        // 카테고리는 이것만 존재
        item.setCtgrHirkNm(jo.optString("CTGR_FULL_NM"));

        // 나머지 카테고리 필드는 API에 없음 → 빈 문자열 처리
        item.setCtgrHirkId("");
        item.setCtgrHirkIdMid("");
        item.setCtgrHirkNmMid("");

        item.setSido(jo.optString("SIDO"));
        item.setDtlAddr(jo.optString("LDNM_ADRS"));

        // 감정가
        item.setGoodsPrice(jo.optLong("APSL_ASES_AVG_AMT", 0));

        return item;
    }


}

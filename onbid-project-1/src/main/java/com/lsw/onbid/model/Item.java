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
        item.setCtgrHirkId(jo.optString("CTGR_HIRK_ID"));
        item.setCtgrHirkNm(jo.optString("CTGR_HIRK_NM"));
        item.setCtgrHirkIdMid(jo.optString("CTGR_HIRK_ID_MID"));
        item.setCtgrHirkNmMid(jo.optString("CTGR_HIRK_NM_MID"));
        item.setSido(jo.optString("SIDO_NM"));
        item.setDtlAddr(jo.optString("LDNM_ADRS"));
        item.setGoodsPrice(jo.optLong("APSL_ASES_AVG_AMT"));

        return item;
    }
}

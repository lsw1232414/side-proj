package com.lsw.onbid.model;

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
}

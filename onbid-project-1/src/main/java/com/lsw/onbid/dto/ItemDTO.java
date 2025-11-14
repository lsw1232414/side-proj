package com.lsw.onbid.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String cltrMnmtNo;
    private String cltrNo;
    private String cltrNm;
    private String dpslMtdNm;
    private String ctgrHirkNm;
    private String ctgrHirkNmMid;
    private String sido;
    private String dtlAddr;
    private Long goodsPrice;
}

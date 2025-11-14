package com.lsw.onbid.model;

import lombok.Data;

@Data
public class History {

    private Long id;
    private String cltrHstrNo;
    private String cltrNo;
    private String pbctBegnDtm;
    private String pbctClsDtm;
    private Long openPrice;
    private String cltrSttsNm;
}

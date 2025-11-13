package com.lsw.onbid.model;

import lombok.Data;

@Data
public class Item {
    private Long itemId;
    private String cltrNo;
    private String cltrNm;
    private String category;
    private String address;
    private Long appraisalPrice;
    private String updatedAt;   // <----- 반드시 추가!!
}

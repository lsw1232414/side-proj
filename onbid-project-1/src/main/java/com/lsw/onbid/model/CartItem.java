package com.lsw.onbid.model;

import lombok.Data;

@Data
public class CartItem {
    private Long id;
    private String cltrNm;
    private Long goodsPrice;
    private String sido;
    private String dtlAddr;
}

package com.lsw.onbid.model;

import lombok.Data;

@Data
public class CartItem {
    private Long id;        // Cart PK
    private Long itemId;    // ★ 실제 item 테이블의 FK (필수)
    private String cltrNm;
    private Long goodsPrice;
    private String sido;
    private String dtlAddr;
}

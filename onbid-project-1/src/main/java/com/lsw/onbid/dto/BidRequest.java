package com.lsw.onbid.dto;

import lombok.Data;


@Data
public class BidRequest {
    private Long itemId;
    private String username;   
    private String phone;
    private Long bidPrice;
}

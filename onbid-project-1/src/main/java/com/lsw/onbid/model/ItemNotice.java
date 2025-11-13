package com.lsw.onbid.model;

import lombok.Data;

@Data
public class ItemNotice {
    private Long noticeId;
    private Long itemId;
    private Long minBidPrice;
    private String startDate;
    private String endDate;
    private String status;
    private String disposalType;
}

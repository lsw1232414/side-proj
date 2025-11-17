package com.lsw.onbid.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class BidResponse {
    private Long id;
    private String username;
    private String phone;
    private Long bidPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    private String cltrNm;
}

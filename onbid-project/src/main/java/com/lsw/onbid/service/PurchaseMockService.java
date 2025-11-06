package com.lsw.onbid.service;

import org.springframework.stereotype.Service;
import java.util.UUID;
import com.lsw.onbid.dto.PurchaseRequest;

@Service
public class PurchaseMockService {

    public String mockPurchase(PurchaseRequest request) {
        // 실제 결제 대신 Mock 처리
        String orderId = UUID.randomUUID().toString();

        return String.format(
            "✅ Mock 구매 완료\n- 주문번호: %s\n- 사용자: %s\n- 상품ID: %s\n- 수량: %d",
            orderId,
            request.getUserId(),
            request.getItemId(),
            request.getQuantity()
        );
    }
}

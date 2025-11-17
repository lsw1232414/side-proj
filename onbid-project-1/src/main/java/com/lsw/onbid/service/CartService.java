package com.lsw.onbid.service;

import com.lsw.onbid.mapper.CartMapper;
import com.lsw.onbid.model.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;

    // 장바구니 추가
    public void addItem(Long itemId) {
        cartMapper.insert(itemId);
    }

    // 장바구니 목록 조회
    public List<CartItem> getCartList() {
        return cartMapper.findAll();
    }

    // 선택 삭제
    public void deleteSelected(List<Long> cartIds) {
        if (!cartIds.isEmpty()) {
            cartMapper.deleteSelected(cartIds);
        }
    }

    // 전체 삭제
    public void clearAll() {
        cartMapper.clearAll();
    }

    // 선택 구매 (Mock 구매)
    public void buySelected(List<Long> cartIds) {
        if (!cartIds.isEmpty()) {
            // 구매 즉시 cart에서 삭제
            cartMapper.deleteSelected(cartIds);
        }
    }
}

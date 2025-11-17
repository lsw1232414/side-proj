package com.lsw.onbid.controller;

import com.lsw.onbid.model.CartItem;
import com.lsw.onbid.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    // 장바구니 페이지
    @GetMapping
    public String cartPage(Map<String, Object> model) {
        List<CartItem> list = cartService.getCartList();
        model.put("list", list);
        return "cart";  // cart.html 이동
    }

    // 장바구니 추가
    @PostMapping("/add/{itemId}")
    @ResponseBody
    public String addCart(@PathVariable Long itemId) {
        cartService.addItem(itemId);
        return "OK";
    }

    // 선택 삭제
    @PostMapping("/delete")
    @ResponseBody
    public String deleteSelected(@RequestBody List<Long> cartIds) {
        cartService.deleteSelected(cartIds);
        return "OK";
    }

    // 전체 비우기
    @PostMapping("/clear")
    @ResponseBody
    public String clear() {
        cartService.clearAll();
        return "OK";
    }

    // 선택 구매
    @PostMapping("/buy")
    @ResponseBody
    public String buySelected(@RequestBody List<Long> cartIds) {
        cartService.buySelected(cartIds);
        return "구매 완료!";
    }
}

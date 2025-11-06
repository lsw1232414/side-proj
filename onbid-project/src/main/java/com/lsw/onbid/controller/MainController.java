package com.lsw.onbid.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lsw.onbid.dto.OnbidItemDto;
import com.lsw.onbid.entity.User;
import com.lsw.onbid.service.OnbidService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    private final OnbidService onbidService;

    public MainController(OnbidService onbidService) {
        this.onbidService = onbidService;
    }

    @GetMapping("/")
    public String mainPage() {
        return "index"; // index.html
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(required = false) String sido,
            @RequestParam(required = false) String category,
            Model model) {

        List<OnbidItemDto> items = onbidService.searchItems(sido, category);
        model.addAttribute("items", items);

        return "search"; // search.html
    }

    @GetMapping("/item/{cltrNo}")
    public String itemDetail(@PathVariable String cltrNo, Model model, HttpSession session) {
        OnbidItemDto item = onbidService.getItemDetail(cltrNo);
        model.addAttribute("item", item);

        User loginUser = (User) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser); // 로그인 여부 확인용

        return "item-detail"; // item-detail.html
    }
}

package com.lsw.onbid.controller;

import com.lsw.onbid.dto.BidRequest;
import com.lsw.onbid.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/bid")
@RequiredArgsConstructor
public class BidController {

    private final BidService bidService;

    @PostMapping("/submit")
    @ResponseBody
    public String submit(@RequestBody BidRequest request) {
        bidService.submitBid(request);
        return "입찰 완료!";
    }

    @GetMapping("/list")
    public String bidList(Model model) {
        model.addAttribute("bids", bidService.getAllBids());
        return "bid-list";
    }

    // ✅ 선택 삭제
    @PostMapping("/delete")
    @ResponseBody
    public String deleteSelected(@RequestBody List<Long> ids) {
        bidService.deleteSelected(ids);
        return "선택한 입찰 기록을 삭제했습니다.";
    }

    // ✅ 전체 비우기
    @PostMapping("/clear")
    @ResponseBody
    public String clearAll() {
        bidService.clearAll();
        return "모든 입찰 기록을 삭제했습니다.";
    }
}

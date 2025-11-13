package com.lsw.onbid.controller;

import com.lsw.onbid.service.OnbidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.lsw.onbid.model.Item;

@RestController
@RequiredArgsConstructor
@RequestMapping("/onbid")
public class OnbidController {

    private final OnbidService onbidService;

    /** 전체 데이터 동기화 */
    @PostMapping("/update")
    public String update() {
        onbidService.syncAll();
        return "전체 동기화 완료!";
    }

    /** 최근 4개 조회 */
    @GetMapping("/latest")
    public List<Item> latest() {
        return onbidService.getLatestItems();
    }
}

package com.lsw.onbid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.lsw.onbid.model.History;
import com.lsw.onbid.model.Item;
import com.lsw.onbid.service.OnbidService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/onbid/api")
@RequiredArgsConstructor
public class OnbidRestController {

    private final OnbidService service;

    /** 전체 목록 혹은 검색 */
    @GetMapping("/search")
    public List<Item> search(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String cate1,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice
    ) {
        return service.search(keyword, cate1, minPrice, maxPrice);
    }

    /** 단건 조회 */
    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return service.findById(id);
    }

    /** 이력 조회 */
    @GetMapping("/item/{cltrNo}/history")
    public List<History> getHistory(@PathVariable String cltrNo) {
        return service.findHistory(cltrNo);
    }

    /** DB 갱신 (지금은 더미) */
    @PostMapping("/sync")
    public String sync() {
        service.syncFromApi();
        return "ok";
    }
}

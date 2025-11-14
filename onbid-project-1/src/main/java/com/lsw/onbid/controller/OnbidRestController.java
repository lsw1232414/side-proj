package com.lsw.onbid.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.lsw.onbid.service.OnbidService;
import com.lsw.onbid.model.Item;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/onbid/api")
public class OnbidRestController {

    private final OnbidService service;

    @PostMapping("/sync")
    public String sync() {
        service.syncFromApi();
        return "ok";
    }

    @GetMapping("/search")
    public List<Item> search(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String cate1,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice
    ) {
        return service.search(keyword, cate1, minPrice, maxPrice);
    }
}

package com.lsw.onbid.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.onbid.model.Item;
import com.lsw.onbid.service.OnbidService;

import lombok.RequiredArgsConstructor;

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
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice
    ) {
        return service.search(keyword, minPrice, maxPrice);
    }
}

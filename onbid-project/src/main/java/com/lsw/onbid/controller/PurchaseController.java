package com.lsw.onbid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lsw.onbid.dto.PurchaseRequest;
import com.lsw.onbid.service.PurchaseMockService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseMockService purchaseMockService;

    @PostMapping("/mock")
    public String mockPurchase(@RequestBody PurchaseRequest request) {
        return purchaseMockService.mockPurchase(request);
    }
}

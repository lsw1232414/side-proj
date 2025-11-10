package com.lsw.onbid.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lsw.onbid.service.OnbidService;
import java.util.List;
import java.util.Map;

@RestController
public class OnbidController {

    private final OnbidService onbidService;

    public OnbidController(OnbidService onbidService) {
        this.onbidService = onbidService;
    }

    @GetMapping("/onbid/list")
    public List<Map<String, Object>> getOnbidList() {
        return onbidService.fetchOnbidData();
    }
}

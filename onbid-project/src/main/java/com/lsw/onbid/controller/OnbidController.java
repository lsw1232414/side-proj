package com.lsw.onbid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsw.onbid.OnbidProjectApplication;
import com.lsw.onbid.dto.OnbidItemDto;
import com.lsw.onbid.service.OnbidService;

@RestController
public class OnbidController {

    private final OnbidProjectApplication onbidProjectApplication;

    @Autowired
    private OnbidService onbidService;

    OnbidController(OnbidProjectApplication onbidProjectApplication) {
        this.onbidProjectApplication = onbidProjectApplication;
    }

    // 테스트용 API
    @GetMapping("/onbid/test")
    public String test() {
        return "✅ Onbid API Controller Ready!";
    }

    // 실제 온비드 API 호출
    @GetMapping("/onbid/list")
    public List<OnbidItemDto> getOnbidList() {
        return onbidService.fetchOnbidData();
    }

}

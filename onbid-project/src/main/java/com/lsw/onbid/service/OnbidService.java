package com.lsw.onbid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lsw.onbid.dto.OnbidItemDto;

@Service
public class OnbidService {

    // 기존 검색 메서드
    public List<OnbidItemDto> searchItems(String sido, String category) {
        // TODO: 실제 온비드 API 호출 후 필터링 구현
        return new ArrayList<>();
    }

    // 컨트롤러에서 호출할 기본 메서드
    public List<OnbidItemDto> fetchOnbidData() {
        // 기본값으로 전체 데이터를 가져오도록 호출
        return searchItems("전체", "전체");
    }

    public OnbidItemDto getItemDetail(String cltrNo) {
        // TODO: 단일 매물 상세 API 호출
        return new OnbidItemDto();
    }
}

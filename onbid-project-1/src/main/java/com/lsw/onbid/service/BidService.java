package com.lsw.onbid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsw.onbid.dto.BidRequest;
import com.lsw.onbid.dto.BidResponse;
import com.lsw.onbid.mapper.BidMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BidService {

    private final BidMapper bidMapper;

    public void submitBid(BidRequest req) {
        bidMapper.insert(req);
    }

    public List<BidResponse> getAllBids() {
        return bidMapper.findAll();
    }

    // ✅ 선택 삭제
    public void deleteSelected(List<Long> ids) {
        if (ids == null || ids.isEmpty()) return;
        bidMapper.deleteSelected(ids);
    }

    // ✅ 전체 삭제
    public void clearAll() {
        bidMapper.clearAll();
    }
}

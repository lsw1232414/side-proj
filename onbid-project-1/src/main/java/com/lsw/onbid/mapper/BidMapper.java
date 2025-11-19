package com.lsw.onbid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lsw.onbid.dto.BidRequest;
import com.lsw.onbid.dto.BidResponse;

@Mapper
public interface BidMapper {

    void insert(BidRequest request);

    List<BidResponse> findAll();

    // ✅ 선택 삭제
    void deleteSelected(List<Long> ids);

    // ✅ 전체 삭제
    void clearAll();
    void truncate();
}

package com.lsw.onbid.service;

import org.springframework.stereotype.Service;

import com.lsw.onbid.mapper.HistoryMapper;
import com.lsw.onbid.model.History;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryMapper historyMapper;

    public History findLatest(String cltrNo) {
        return historyMapper.findLatestByCltrNo(cltrNo);
    }
}

package com.lsw.onbid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsw.onbid.mapper.HistoryMapper;
import com.lsw.onbid.mapper.ItemMapper;
import com.lsw.onbid.model.History;
import com.lsw.onbid.model.Item;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OnbidService {

    private final ItemMapper itemMapper;
    private final HistoryMapper historyMapper;

    /** 전체 물건 조회 */
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    /** 검색 */
    public List<Item> search(String keyword, String cate1, Long minPrice, Long maxPrice) {
        return itemMapper.search(keyword, cate1, minPrice, maxPrice);
    }

    /** 단건 조회 */
    public Item findById(Long id) {
        return itemMapper.findById(id);
    }

    /** 이력 조회 */
    public List<History> findHistory(String cltrNo) {
        return historyMapper.findByCltrNo(cltrNo);
    }

    /** (추후) API 연동해서 DB 갱신 – 지금은 더미 */
    public void syncFromApi() {
        // TODO: 나중에 공공API 연결해서 item/history INSERT/UPDATE
        System.out.println("🔵 [TODO] 공공 API 연동 후 DB 갱신 로직 구현 예정");
    }
}

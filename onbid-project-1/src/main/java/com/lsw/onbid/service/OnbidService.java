package com.lsw.onbid.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lsw.onbid.mapper.HistoryMapper;
import com.lsw.onbid.mapper.ItemMapper;
import com.lsw.onbid.model.History;
import com.lsw.onbid.model.Item;
import com.lsw.onbid.util.ExternalApiClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OnbidService {

    private final ExternalApiClient api;
    private final ItemMapper itemMapper;
    private final HistoryMapper historyMapper;

    public void syncFromApi() {

        log.info("📌 전체 초기화 시작: item + history 테이블 비움");

        itemMapper.truncate();
        historyMapper.truncate();

        int saved = 0;

        int total = api.getTotalCount();
        if (total == 0) {
            log.warn("⚠ totalCount=0 → 중단");
            return;
        }

        int pageSize = 100;
        int totalPages = (int) Math.ceil(total / (double) pageSize);

        for (int page = 1; page <= totalPages; page++) {

            JSONArray arr = api.fetchItems(page, pageSize);

            for (int i = 0; i < arr.length(); i++) {

                JSONObject jo = arr.getJSONObject(i);

                // ======== ITEM 저장 ========
                Item item = Item.fromJson(jo);

                Item exist = itemMapper.findByPk(item.getCltrNo(), item.getCltrMnmtNo());
                if (exist == null) {
                    itemMapper.insert(item);
                }

                // ======== HISTORY 저장 ========
                History h = History.fromJson(jo);

                // 저장
                historyMapper.insert(h);

                saved++;

                if (saved >= 1000) {
                    log.info("⛔ 1000건 수집 완료 → 강제 종료");
                    return;
                }
            }

            log.info("📄 {} / {} 페이지 완료", page, totalPages);
        }

        log.info("🎉 전체 Sync 완료 — 총 {}건 저장됨", saved);
    }

    public List<Item> search(String keyword, Long minPrice, Long maxPrice) {
        return itemMapper.searchNoCate(keyword, minPrice, maxPrice);
    }
}

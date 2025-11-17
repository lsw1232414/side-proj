package com.lsw.onbid.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.lsw.onbid.mapper.ItemMapper;
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

    public void syncFromApi() {

        log.info("📌 전체 초기화 모드: item 테이블 비움");
        itemMapper.truncate();  // ★★★ 테이블 싹 초기화

        int savedCount = 0;

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

                if (savedCount >= 1000) {
                    log.info("⛔ 1000개 저장 완료 → Sync 강제 종료");
                    return;
                }

                Item item = Item.fromJson(arr.getJSONObject(i));

                // ⭐ API 결과 중복 방지
                Item exist = itemMapper.findByPk(item.getCltrNo(), item.getCltrMnmtNo());
                if (exist == null) {
                    itemMapper.insert(item);
                    savedCount++;
                }
            }

            log.info("→ {} / {} 페이지 완료", page, totalPages);
        }


        log.info("🎉 전체 초기화 + 전체 재수집 완료 (총 {}건)", savedCount);
    }


    public List<Item> search(String keyword, Long minPrice, Long maxPrice) {
        return itemMapper.searchNoCate(keyword, minPrice, maxPrice);
    }


}

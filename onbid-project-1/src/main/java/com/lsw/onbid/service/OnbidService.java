package com.lsw.onbid.service;

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

        log.info("📌 API → DB 전체 동기화 시작");

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

                Item item = Item.fromJson(arr.getJSONObject(i));

                // ★ 핵심: 공매번호 + 물건관리번호로 조회
                Item exist = itemMapper.findByPk(item.getCltrNo(), item.getCltrMnmtNo());

                if (exist == null) {
                    itemMapper.insert(item);
                } else {
                    itemMapper.update(item);
                }
            }

            log.info("→ {} / {} 페이지 완료", page, totalPages);
        }

        log.info("🎉 모든 데이터 동기화 완료");
    }

    public java.util.List<Item> search(String keyword, String cate1, Long minPrice, Long maxPrice) {
        return itemMapper.search(keyword, cate1, minPrice, maxPrice);
    }
}

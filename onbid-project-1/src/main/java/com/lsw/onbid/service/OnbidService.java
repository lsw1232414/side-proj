package com.lsw.onbid.service;

import com.lsw.onbid.mapper.ItemMapper;
import com.lsw.onbid.model.Item;
import com.lsw.onbid.util.ExternalApiClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OnbidService {

    private final ExternalApiClient api;
    private final ItemMapper itemMapper;

    /**
     * 전체 데이터 동기화 (최초 8만건 + 이후 변경건만)
     */
    public void syncAll() {

        int totalCount = api.getTotalCount();
        int rows = 100;
        int totalPages = (int) Math.ceil(totalCount / (double) rows);

        for (int page = 1; page <= totalPages; page++) {

            JSONArray items = api.fetchPage(page, rows);

            for (Object obj : items) {
                JSONObject json = (JSONObject) obj;

                Item item = jsonToItem(json);

                Item exist = itemMapper.findByCltrNo(item.getCltrNo());

                if (exist == null) {
                    itemMapper.insertItem(item);
                } else {
                    // 변경 여부 비교 후 다르면 update
                    itemMapper.updateItem(item);
                }
            }
        }

        System.out.println("🔵 전체 동기화 완료: 총 " + totalCount + " 건");
    }

    private Item jsonToItem(JSONObject json) {

        Item item = new Item();

        item.setCltrNo(json.optString("CLTR_NO"));
        item.setCltrNm(json.optString("CLTR_NM"));
        item.setCategory(json.optString("CTGR_FULL_NM"));
        item.setAddress(json.optString("NMRD_ADRS"));
        item.setAppraisalPrice(json.optLong("APSL_ASES_AVG_AMT"));

        return item;
    }

    public List<Item> getLatestItems() {
        return itemMapper.findLatestItems();
    }
}

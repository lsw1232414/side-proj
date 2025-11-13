package com.lsw.onbid.mapper;

import com.lsw.onbid.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    void insertItem(Item item);

    void updateItem(Item item);

    Item findByCltrNo(String cltrNo);

    String findLastUpdatedAt();

    List<Item> findLatestItems();   // ← 이거 반드시 필요!
}

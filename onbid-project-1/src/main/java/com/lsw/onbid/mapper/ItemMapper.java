package com.lsw.onbid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lsw.onbid.model.Item;

@Mapper
public interface ItemMapper {

    List<Item> findAll();

    Item findById(Long id);

    List<Item> search(@Param("keyword") String keyword,
                      @Param("cate1") String cate1,
                      @Param("minPrice") Long minPrice,
                      @Param("maxPrice") Long maxPrice);

    void insert(Item item);

    void update(Item item);

    Item findByCltrNo(String cltrNo);   // ← 추가됨
}

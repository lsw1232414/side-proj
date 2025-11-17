package com.lsw.onbid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lsw.onbid.model.Item;

@Mapper
public interface ItemMapper {

    // ★ 존재 여부 확인용 (PK 조합)
    Item findByPk(@Param("cltrNo") String cltrNo,
                  @Param("cltrMnmtNo") String cltrMnmtNo);
    Item findByCltrNo(String cltrNo);
    
    // 검색
    List<Item> searchNoCate(@Param("keyword") String keyword,
            @Param("minPrice") Long minPrice,
            @Param("maxPrice") Long maxPrice);

    
    // 삭제
    void truncate();
    // 삽입
    void insert(Item item);

    // 수정
    void update(Item item);
    
    Item findById(Long id);

}

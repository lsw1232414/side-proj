package com.lsw.onbid.mapper;

import com.lsw.onbid.model.CartItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {

    void insert(Long itemId);

    List<CartItem> findAll();

    void deleteSelected(List<Long> ids);

    void clearAll();
}

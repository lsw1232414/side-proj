package com.lsw.onbid.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.lsw.onbid.mapper.ItemMapper;
import com.lsw.onbid.model.Item;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    public Item findById(Long id) {
        return itemMapper.findById(id);
    }
}

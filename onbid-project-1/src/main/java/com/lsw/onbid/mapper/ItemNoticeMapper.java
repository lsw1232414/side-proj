package com.lsw.onbid.mapper;

import com.lsw.onbid.model.ItemNotice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemNoticeMapper {

    void insertItemNotice(ItemNotice notice);

    ItemNotice findByNoticeId(Long noticeId);
}

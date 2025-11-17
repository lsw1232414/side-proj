package com.lsw.onbid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lsw.onbid.model.History;

@Mapper
public interface HistoryMapper {

    List<History> findByCltrNo(@Param("cltrNo") String cltrNo);

    History findLatestByCltrNo(@Param("cltrNo") String cltrNo);

    // ★★★★★ 추가해야 하는 메서드 2개 ★★★★★
    void insert(History history);

    void truncate();
}

package com.lsw.onbid.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lsw.onbid.model.History;

@Mapper
public interface HistoryMapper {

    List<History> findByCltrNo(@Param("cltrNo") String cltrNo);
}

package com.mr.easybuy.wares.mapper;

import com.mr.easybuy.wares.entity.WaresVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaresMapper {

    int findTiao(WaresVO waresVO);

    List<WaresVO> findWaresList(WaresVO waresVO);

    WaresVO findGoodsById(WaresVO waresVO);

    int update(WaresVO waresVO);

    int add(WaresVO waresVO);
}

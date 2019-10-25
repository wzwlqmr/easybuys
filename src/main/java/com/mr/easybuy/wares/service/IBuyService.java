package com.mr.easybuy.wares.service;

import com.mr.easybuy.wares.entity.WaresVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IBuyService {

    WaresVO shoppingSale(WaresVO waresVO);

    Map<String, Object> insertDeal(WaresVO waresVO, HttpServletRequest request);

    List<WaresVO> findGoodsByIds(String ids);
}

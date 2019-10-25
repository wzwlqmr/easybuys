package com.mr.easybuy.wares.service;

import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.util.DataGrid;

public interface IWareService {

    DataGrid findWaresList(WaresVO waresVO);

    WaresVO findGoodsById(WaresVO waresVO);

    int update(WaresVO waresVO);

    int add(WaresVO waresVO);
}

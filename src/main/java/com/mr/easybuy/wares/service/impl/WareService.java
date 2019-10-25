package com.mr.easybuy.wares.service.impl;

import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.mapper.WaresMapper;
import com.mr.easybuy.wares.service.IWareService;
import com.mr.easybuy.wares.util.DataGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WareService implements IWareService {

    @Autowired
    private WaresMapper waresMapper;


    @Override
    public DataGrid findWaresList(WaresVO waresVO) {
        DataGrid dg=new DataGrid();
        int total=waresMapper.findTiao(waresVO);
        waresVO.calculate();
        List<WaresVO> list=waresMapper.findWaresList(waresVO);
        dg.setTotal(total);
        dg.setRows(list);
        return dg;
    }

    @Override
    public WaresVO findGoodsById(WaresVO waresVO) {
        return waresMapper.findGoodsById(waresVO);
    }

    @Override
    public int add(WaresVO waresVO) {
        String s = UUID.randomUUID().toString().substring(0,6);
        waresVO.setGood_id(s);
        return waresMapper.add(waresVO);
    }
    @Override
    public int update(WaresVO waresVO) {
        return waresMapper.update(waresVO);
    }
}

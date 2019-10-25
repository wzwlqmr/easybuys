package com.mr.easybuy.wares.service.impl;

import com.alibaba.fastjson.JSON;
import com.mr.easybuy.wares.entity.CommonConstant;
import com.mr.easybuy.wares.entity.UserVO;
import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.util.rabbitMQ.ProducerSenderMQ;
import com.mr.easybuy.wares.util.redis.RedisUtil;
import com.mr.easybuy.wares.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@Service
public class BuyService implements IBuyService {

    @Autowired
    private ProducerSenderMQ producerSenderMQ;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public WaresVO shoppingSale(WaresVO waresVO) {
        WaresVO waresVO1 = (WaresVO) redisUtil.get(waresVO.getGood_id());
        return waresVO1;
    }

    @Override
    public Map<String, Object> insertDeal(WaresVO waresVO, HttpServletRequest request) {
        Map<String,Object> maps = new HashMap<>();
        WaresVO waresVO1 = (WaresVO) redisUtil.get(waresVO.getGood_id());
        System.out.println(waresVO1);
        //判断库存是否充足
        if(waresVO1.getGood_count()<waresVO.getGood_count() && waresVO.getGood_count()>0){
            maps.put(CommonConstant.ERROR_CODE,201); //库存不足
            return maps;
        }
        //判断抢购时间
        if(new Date().getTime()>waresVO1.getEndTime().getTime()){
            maps.put(CommonConstant.ERROR_CODE,202); //时辰已到
            return maps;
        }

        //如果都满足 获取session中登陆状态 放进map
        Map<String,Object> saveMap=new HashMap<>();
        UserVO userVO = (UserVO) request.getSession().getAttribute("userVO");
        saveMap.put("userVO",userVO);
        saveMap.put("waresVO",waresVO);
        //发送mq请求
        producerSenderMQ.sender(JSON.toJSONString(saveMap));
        //更新redis中的缓存
        waresVO1.setGood_count(waresVO1.getGood_count()-waresVO.getGood_count());
        redisUtil.set(waresVO1.getGood_id(),waresVO1);

        maps.put(CommonConstant.ERROR_CODE,200);
        return maps;
    }

    @Override
    public List<WaresVO> findGoodsByIds(String ids) {
        // 处理ids
        String[] idsTemp = ids.split(",");
        // 设置一个list用来接受查询的数据
        List<WaresVO> goodsList = new ArrayList<>(10);
        WaresVO waresVO = new WaresVO();
        for (int i=0;i<idsTemp.length;i++){
            System.out.println(idsTemp[i].trim());
            waresVO = (WaresVO) redisUtil.get(idsTemp[i].trim());
            goodsList.add(waresVO);
        }

        System.out.println(goodsList);
        return goodsList;
    }
}

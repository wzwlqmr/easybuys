package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.util.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private RedisUtil redisUtil;

//    @Autowired
//    private IShopService shopService;
//
    /*/**
    * @Description: toIndex 去首页
    * @Param: []
    * @return: java.lang.String
    * @Author: yxy
    * @Date: 2019/10/11
    */
    @GetMapping("/toIndex")
    public String toIndex(HttpServletRequest req){
//
//        List<GoodVO> goodList = shopService.findProductList();
//
//
//
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse("2019-10-16 23:59:59");
        }catch (Exception e){
            e.printStackTrace();
        }

        WaresVO gd11 = new WaresVO();
        gd11.setGood_id("a1");
        gd11.setGood_name("彩虹马");
        gd11.setGood_price(10000.0);
        gd11.setPriceDiscount(0.3);
        gd11.setEndTime(date);
        gd11.setGood_count(30);
        redisUtil.set("a1",gd11);

        WaresVO gd12 = new WaresVO();
        gd12.setGood_id("a2");
        gd12.setGood_name("爆炸果实");
        gd12.setGood_price(188.0);
        gd12.setPriceDiscount(0.3);
        gd12.setEndTime(date);
        gd12.setGood_count(60);
        redisUtil.set("a2",gd12);

        WaresVO gd13 = new WaresVO();
        gd13.setGood_id("a3");
        gd13.setGood_name("澳大利亚蓝莓/盒");
        gd13.setGood_price(18.0);
        gd13.setPriceDiscount(0.3);
        gd13.setEndTime(date);
        gd13.setGood_count(50);
        redisUtil.set("a3",gd13);

        WaresVO gd14 = new WaresVO();
        gd14.setGood_id("a4");
        gd14.setGood_name("大凉山苹果500g/盒");
        gd14.setGood_price(188.0);
        gd14.setPriceDiscount(0.3);
        gd14.setEndTime(date);
        gd14.setGood_count(10);
        redisUtil.set("a4",gd14);

        WaresVO gd1 = new WaresVO();
        gd1.setGood_id("a");
        gd1.setGood_name("公牛");
        gd1.setGood_price(108.0);
        gd1.setPriceDiscount(0.3);
        gd1.setEndTime(date);
        gd1.setGood_count(10);
        redisUtil.set("a",gd1);

        WaresVO gd2 = new WaresVO();
        gd2.setGood_id("a5");
        gd2.setGood_name("乐扣普通型保鲜盒圣诞7件套");
        gd2.setGood_price(69.90);
        gd2.setPriceDiscount(0.3);
        gd2.setEndTime(date);
        gd2.setGood_count(30);
        redisUtil.set("a5",gd2);

        WaresVO gd3 = new WaresVO();
        gd3.setGood_id("a6");
        gd3.setGood_name("欧珀莱均衡保湿四件套");
        gd3.setGood_price(279.0);
        gd3.setPriceDiscount(0.3);
        gd3.setEndTime(date);
        gd3.setGood_count(40);
        redisUtil.set("a6",gd3);

        WaresVO gd4 = new WaresVO();
        gd4.setGood_id("a7");
        gd4.setGood_name("联想笔记本电脑 高速独立显存");
        gd4.setGood_price(4199.0);
        gd4.setPriceDiscount(0.3);
        gd4.setEndTime(date);
        gd4.setGood_count(50);
        redisUtil.set("a7",gd4);

        HttpSession session = req.getSession();
        System.out.println(session);
        return "shopIndex";
    }

}

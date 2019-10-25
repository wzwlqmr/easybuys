package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.entity.CommonConstant;
import com.mr.easybuy.wares.entity.UserVO;
import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.service.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopping")
public class BuyController {

    @Autowired
    private IBuyService buyService;

    @ResponseBody
    @RequestMapping("findGoodsByIds")
    public List<WaresVO> findGoodsByIds(String ids){
        System.out.println("数据"+ids);
        return buyService.findGoodsByIds(ids);
    }

    @RequestMapping("myOrder")
    public String myOrder(ModelMap mmp,String ids){
        List<WaresVO> list=buyService.findGoodsByIds(ids);
        System.out.println(list.get(0));
        mmp.put("list",list.get(0));
        return "myOrder";
    }

    @ResponseBody
    @RequestMapping("insertDeal")
    public Map<String,Object> insertDeal(WaresVO waresVO,HttpServletRequest request){
        return buyService.insertDeal(waresVO,request);
    }

    @RequestMapping("shoppingSale")
    public String shoppingSale(ModelMap map,WaresVO waresVO){
        WaresVO waresVO1=buyService.shoppingSale(waresVO);
        map.put("goodVO",waresVO1);
        return "/shoppingSale";
    }

    @ResponseBody
    @PostMapping("/isLogin")
    public Map<String,Object> isLogin(HttpServletRequest request){
        Map<String,Object> retMap= new HashMap<>(1);
        // 通过session获取用户信息
        UserVO userVO = (UserVO) request.getSession().getAttribute("userVO");
        // 判断用户是否登陆
        if(userVO==null){
            retMap.put(CommonConstant.ERROR_CODE,"201");//未登录返回201
            return retMap;
        }
        retMap.put(CommonConstant.ERROR_CODE,"200");//登录返回200
        return retMap;
    }
    @RequestMapping("shoppingIndex")
    public String shoppingIndex(){
        return "shoppingIndex";
    }

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("toShopingCart")
    public String toShopingCart(){
        return "shoppingCart";
    }



}

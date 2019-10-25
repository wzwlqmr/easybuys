package com.mr.easybuy.wares.controller;

import com.alibaba.fastjson.JSON;
import com.mr.easybuy.wares.util.es.EsUtilss;
import org.elasticsearch.common.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ElasticsearchTests {

    @Autowired
    private EsUtilss esUtilss;
    @ResponseBody
    @RequestMapping("testAdd")
    public String testAdd(){
        Map<String,Object> map=new HashMap<>();
        map.put("user","bbb");
        map.put("postDate",new Date());
        map.put("message","success");
        Map<String,String> map1=new HashMap<>();
        map1.put("index","wzw");
        map1.put("type","doc");
        map1.put("id","2");
        esUtilss.addIndexByAsyn(JSON.toJSONString(map),map1);
        return "success";
    }
    @ResponseBody
    @RequestMapping("testUpdate")
    public String testUpdate(){
        Map<String,Object> map=new HashMap<>();
        map.put("user","ccc");
        map.put("postDate",new Date());
        map.put("message","垃圾刘普");
        Map<String,String> map1=new HashMap<>();
        map1.put("index","wzw");
        map1.put("type","doc");
        map1.put("id","2");
        esUtilss.addIndexByAsyn(JSON.toJSONString(map),map1);
        return "success";
    }
    @ResponseBody
    @RequestMapping("testDelete")
    public String testDelete(){
        Map<String,String> map1=new HashMap<>();
        map1.put("index","wzw");
        map1.put("type","doc");
        map1.put("id","2");
        esUtilss.deleIndex(map1);
        return "success";
    }

    @ResponseBody
    @GetMapping("/testGet")
    private String testGet(){
        Map<String,String> indexMap= new HashMap<>();
        indexMap.put("index","wzw");
        indexMap.put("type","doc");
        indexMap.put("id","4");
        String[] includes = {"*Date","message"};
        String[] excludes = Strings.EMPTY_ARRAY;
        esUtilss.findByGet(indexMap,includes,excludes);
        return "success";
    }
}

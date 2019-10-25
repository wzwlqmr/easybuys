package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.util.es.EsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ElasticsearchTest {

    @Autowired
    private EsUtils esUtils;

    @ResponseBody
    @GetMapping("TestES")
    private String TestES (){
        esUtils.createIndexInfo("1","doc","3");
        return "success";
    }
}

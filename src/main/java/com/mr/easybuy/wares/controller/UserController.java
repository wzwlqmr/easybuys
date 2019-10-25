package com.mr.easybuy.wares.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("order")
    public String order (){
        return "order";
    }
}

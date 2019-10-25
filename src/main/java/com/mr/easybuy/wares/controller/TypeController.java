package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.service.ITypeService;
import com.mr.easybuy.wares.entity.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @ResponseBody
    @RequestMapping("findTypeList")
    public List<Tree> findTypeList(HttpServletRequest request){
        List<Tree> list= typeService.findTypeList(request);
        return list;
    }


}

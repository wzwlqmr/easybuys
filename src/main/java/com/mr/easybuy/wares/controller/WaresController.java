package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.entity.WaresVO;
import com.mr.easybuy.wares.service.IWareService;
import com.mr.easybuy.wares.util.DataGrid;
import com.mr.easybuy.wares.util.UploadAndDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WaresController {

    @Autowired
    private IWareService wareService;

    @ResponseBody
    @RequestMapping("findWaresList")
    public DataGrid findWaresList(WaresVO waresVO){
        DataGrid dg=wareService.findWaresList(waresVO);
        return dg;
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    @RequestMapping("list")
    public String list(){
        return "list";
    }

    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "update";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }

    //根据id查询
    @ResponseBody
    @RequestMapping("findGoodsById")
    public WaresVO findGoodsById(WaresVO waresVO){
        WaresVO  waresVO1=wareService.findGoodsById(waresVO);
        return waresVO1;
    }

    //添加
    @ResponseBody
    @RequestMapping("add")
    public Map<String,Object> add(WaresVO waresVO){
        Map<String,Object> mp=new HashMap<>();
        int flag = wareService.add(waresVO);
        mp.put("errorCode", flag);
        return mp;
    }
    //修改
    @ResponseBody
    @RequestMapping("update")
    public Map<String,Object> update(WaresVO waresVO){
        Map<String,Object> mp=new HashMap<>();
        int flag = wareService.update(waresVO);
        mp.put("errorCode", flag);
        return mp;
    }
    //上传
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@PathParam("imgFile") MultipartFile imgFile, HttpServletRequest req) {
        String str = UploadAndDownload.upload(imgFile, "D:\\imgDownload", "imgs");
        return str;
    }
    //去下载
    @ResponseBody
    @RequestMapping("toDown")
    public String toDown() {
        return "blank";
    }

    //下载
    @RequestMapping("download")
    public void download(HttpServletResponse resp, String path) {
        UploadAndDownload.download("D:\\imgDownload", path, resp);
    }
    //读取图片
    @RequestMapping("readPic")
    public void readPic(HttpServletResponse resp,String path) {
        UploadAndDownload.readPic("D:\\imgDownload", path, resp);
    }
}

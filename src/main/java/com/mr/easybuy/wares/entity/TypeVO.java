package com.mr.easybuy.wares.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TypeVO{

   private String io_id;
   private String emp_id;
   private String url;
   private Integer io_type;
   private Integer io_count;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   private Date io_date;
   private String pid;

    @Override
    public String toString() {
        return "TypeVO{" +
                "io_id='" + io_id + '\'' +
                ", emp_id='" + emp_id + '\'' +
                ", url='" + url + '\'' +
                ", io_type=" + io_type +
                ", io_count=" + io_count +
                ", io_date=" + io_date +
                ", pid='" + pid + '\'' +
                '}';
    }

    public String getIo_id() {
        return io_id;
    }

    public void setIo_id(String io_id) {
        this.io_id = io_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIo_type() {
        return io_type;
    }

    public void setIo_type(Integer io_type) {
        this.io_type = io_type;
    }

    public Integer getIo_count() {
        return io_count;
    }

    public void setIo_count(Integer io_count) {
        this.io_count = io_count;
    }

    public Date getIo_date() {
        return io_date;
    }

    public void setIo_date(Date io_date) {
        this.io_date = io_date;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}

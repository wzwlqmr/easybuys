package com.mr.easybuy.wares.entity;

import com.mr.easybuy.wares.util.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class WaresVO extends Page implements Serializable {
    private String good_id;
    private String emp_id;
    private String type_id;
    private Double PriceDiscount;
    private String good_name;
    private Double good_price;
    private Integer good_status;
    private Integer good_count;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date good_create_date;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date EndTime;
    private Integer good_type;
    private String good_img;

    @Override
    public String toString() {
        return "WaresVO{" +
                "good_id='" + good_id + '\'' +
                ", emp_id='" + emp_id + '\'' +
                ", type_id='" + type_id + '\'' +
                ", PriceDiscount=" + PriceDiscount +
                ", good_name='" + good_name + '\'' +
                ", good_price=" + good_price +
                ", good_status=" + good_status +
                ", good_count=" + good_count +
                ", good_create_date=" + good_create_date +
                ", EndTime=" + EndTime +
                ", good_type=" + good_type +
                ", good_img='" + good_img + '\'' +
                '}';
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Double getPriceDiscount() {
        return PriceDiscount;
    }

    public void setPriceDiscount(Double priceDiscount) {
        PriceDiscount = priceDiscount;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public Double getGood_price() {
        return good_price;
    }

    public void setGood_price(Double good_price) {
        this.good_price = good_price;
    }

    public Integer getGood_status() {
        return good_status;
    }

    public void setGood_status(Integer good_status) {
        this.good_status = good_status;
    }

    public Integer getGood_count() {
        return good_count;
    }

    public void setGood_count(Integer good_count) {
        this.good_count = good_count;
    }

    public Date getGood_create_date() {
        return good_create_date;
    }

    public void setGood_create_date(Date good_create_date) {
        this.good_create_date = good_create_date;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public Integer getGood_type() {
        return good_type;
    }

    public void setGood_type(Integer good_type) {
        this.good_type = good_type;
    }

    public String getGood_img() {
        return good_img;
    }

    public void setGood_img(String good_img) {
        this.good_img = good_img;
    }
}

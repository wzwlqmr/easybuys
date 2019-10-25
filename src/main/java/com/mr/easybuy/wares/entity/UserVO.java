package com.mr.easybuy.wares.entity;

import java.io.Serializable;
import java.util.Date;

public class UserVO implements Serializable {

    private String user_id;
    private String user_pass;
    private String user_nick;
    private String user_phone_code;
    private Integer user_status;
    private Date user_creat_date;
    private Integer user_inte;
    private Integer user_user_inte;
    private Integer user_grade;
    private String user_img;

    @Override
    public String toString() {
        return "UserVO{" +
                "user_id='" + user_id + '\'' +
                ", user_pass='" + user_pass + '\'' +
                ", user_nick='" + user_nick + '\'' +
                ", user_phone_code='" + user_phone_code + '\'' +
                ", user_status=" + user_status +
                ", user_creat_date=" + user_creat_date +
                ", user_inte=" + user_inte +
                ", user_user_inte=" + user_user_inte +
                ", user_grade=" + user_grade +
                ", user_img='" + user_img + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_phone_code() {
        return user_phone_code;
    }

    public void setUser_phone_code(String user_phone_code) {
        this.user_phone_code = user_phone_code;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Date getUser_creat_date() {
        return user_creat_date;
    }

    public void setUser_creat_date(Date user_creat_date) {
        this.user_creat_date = user_creat_date;
    }

    public Integer getUser_inte() {
        return user_inte;
    }

    public void setUser_inte(Integer user_inte) {
        this.user_inte = user_inte;
    }

    public Integer getUser_user_inte() {
        return user_user_inte;
    }

    public void setUser_user_inte(Integer user_user_inte) {
        this.user_user_inte = user_user_inte;
    }

    public Integer getUser_grade() {
        return user_grade;
    }

    public void setUser_grade(Integer user_grade) {
        this.user_grade = user_grade;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }
}

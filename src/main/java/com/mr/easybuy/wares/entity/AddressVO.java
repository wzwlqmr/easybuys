package com.mr.easybuy.wares.entity;

import java.io.Serializable;
import java.util.Date;

public class AddressVO implements Serializable {

    private String addid;
    private String userid;
    private String addpro;
    private String addcity;
    private String addcountry;
    private String addcountryside;
    private String adddetail;
    private String adduser;
    private String addphone;
    private Date adddate;

    @Override
    public String toString() {
        return "AddressVO{" +
                "addid='" + addid + '\'' +
                ", userid='" + userid + '\'' +
                ", addpro='" + addpro + '\'' +
                ", addcity='" + addcity + '\'' +
                ", addcountry='" + addcountry + '\'' +
                ", addcountryside='" + addcountryside + '\'' +
                ", adddetail='" + adddetail + '\'' +
                ", adduser='" + adduser + '\'' +
                ", addphone='" + addphone + '\'' +
                ", adddate=" + adddate +
                '}';
    }

    public String getAddid() {
        return addid;
    }

    public void setAddid(String addid) {
        this.addid = addid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddpro() {
        return addpro;
    }

    public void setAddpro(String addpro) {
        this.addpro = addpro;
    }

    public String getAddcity() {
        return addcity;
    }

    public void setAddcity(String addcity) {
        this.addcity = addcity;
    }

    public String getAddcountry() {
        return addcountry;
    }

    public void setAddcountry(String addcountry) {
        this.addcountry = addcountry;
    }

    public String getAddcountryside() {
        return addcountryside;
    }

    public void setAddcountryside(String addcountryside) {
        this.addcountryside = addcountryside;
    }

    public String getAdddetail() {
        return adddetail;
    }

    public void setAdddetail(String adddetail) {
        this.adddetail = adddetail;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser;
    }

    public String getAddphone() {
        return addphone;
    }

    public void setAddphone(String addphone) {
        this.addphone = addphone;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
}

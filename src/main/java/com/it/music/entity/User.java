package com.it.music.entity;

/**
 * @author 羡羡
 * 用户表
 */
public class User {
    public int usid;
    public String usname;
    public int sex;
    public int agr;
    public String phone;
    public String password;
    public String usintro;
    public String usimg;
    public int isvip;
    public String viptime;

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAgr() {
        return agr;
    }

    public void setAgr(int agr) {
        this.agr = agr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsintro() {
        return usintro;
    }

    public void setUsintro(String usintro) {
        this.usintro = usintro;
    }

    public String getUsimg() {
        return usimg;
    }

    public void setUsimg(String usimg) {
        this.usimg = usimg;
    }

    public int getIsvip() {
        return isvip;
    }

    public void setIsvip(int isvip) {
        this.isvip = isvip;
    }

    public String getViptime() {
        return viptime;
    }

    public void setViptime(String viptime) {
        this.viptime = viptime;
    }

    public User() {
    }

    public User(String usname, int sex, int agr, String phone, String password, String usintro, String usimg, int isvip, String viptime) {
        this.usname = usname;
        this.sex = sex;
        this.agr = agr;
        this.phone = phone;
        this.password = password;
        this.usintro = usintro;
        this.usimg = usimg;
        this.isvip = isvip;
        this.viptime = viptime;
    }

    public User(int usid, String usname, int sex, int agr, String phone, String password, String usintro, String usimg, int isvip, String viptime) {
        this.usid = usid;
        this.usname = usname;
        this.sex = sex;
        this.agr = agr;
        this.phone = phone;
        this.password = password;
        this.usintro = usintro;
        this.usimg = usimg;
        this.isvip = isvip;
        this.viptime = viptime;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "usid=" + usid +
                ", usname='" + usname + '\'' +
                ", sex=" + sex +
                ", agr=" + agr +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", usintro='" + usintro + '\'' +
                ", usimg='" + usimg + '\'' +
                ", isvip=" + isvip +
                ", viptime='" + viptime + '\'' +
                '}';
    }
}

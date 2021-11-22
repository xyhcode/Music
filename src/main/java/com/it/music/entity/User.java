package com.it.music.entity;

/**
 * @author 羡羡
 * 用户表
 */
public class User {
    public int usid;
    public String usname;
    public int sex;
    public int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public User(String usname, int sex, int age, String phone, String password, String usintro, String usimg, int isvip, String viptime) {
        this.usname = usname;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.password = password;
        this.usintro = usintro;
        this.usimg = usimg;
        this.isvip = isvip;
        this.viptime = viptime;
    }

    public User(int usid, String usname, int sex, int age, String phone, String password, String usintro, String usimg, int isvip, String viptime) {
        this.usid = usid;
        this.usname = usname;
        this.sex = sex;
        this.age = age;
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
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", usintro='" + usintro + '\'' +
                ", usimg='" + usimg + '\'' +
                ", isvip=" + isvip +
                ", viptime='" + viptime + '\'' +
                '}';
    }
}

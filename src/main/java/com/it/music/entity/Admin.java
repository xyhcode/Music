package com.it.music.entity;

/**
 * @author lingjing
 */
public class Admin {
    private int aid;
    private String aname;
    private String password;
    private int sex;
    private int age;
    private String phone;
    private String aimg;
    private int grade;

    public Admin() {
    }

    public Admin(int aid, String aname, String password, int sex, int age, String phone, String aimg, int grade) {
        this.aid = aid;
        this.aname = aname;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.aimg = aimg;
        this.grade = grade;
    }

    public Admin(String aname, String password, int sex, int age, String phone, String aimg, int grade) {
        this.aname = aname;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.aimg = aimg;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "\nAdmin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", aimg='" + aimg + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

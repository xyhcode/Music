package com.it.music.entity;

import lombok.Data;

public class SongNum {

    public int usid;
    public int soid;
    public String sontime;

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public String getSontime() {
        return sontime;
    }

    public void setSontime(String sontime) {
        this.sontime = sontime;
    }

    public SongNum(){

    }

    public SongNum(int usid, int soid, String sontime) {
        this.usid = usid;
        this.soid = soid;
        this.sontime = sontime;
    }

    @Override
    public String toString() {
        return "SongNum{" +
                "usid=" + usid +
                ", soid=" + soid +
                ", sontime='" + sontime + '\'' +
                '}';
    }
}

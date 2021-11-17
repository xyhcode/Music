package com.it.music.entity;

/**
 * @author 羡羡
 */
public class SongType {
    public int sotid;
    public String sotname;
    public int sottype;

    public int getSotid() {
        return sotid;
    }

    public void setSotid(int sotid) {
        this.sotid = sotid;
    }

    public String getSotname() {
        return sotname;
    }

    public void setSotname(String sotname) {
        this.sotname = sotname;
    }

    public int getSottype() {
        return sottype;
    }

    public void setSottype(int sottype) {
        this.sottype = sottype;
    }

    public SongType() {
    }

    public SongType(String sotname, int sottype) {
        this.sotname = sotname;
        this.sottype = sottype;
    }

    public SongType(int sotid, String sotname, int sottype) {
        this.sotid = sotid;
        this.sotname = sotname;
        this.sottype = sottype;
    }

    @Override
    public String toString() {
        return "\nSongType{" +
                "sotid=" + sotid +
                ", sotname='" + sotname + '\'' +
                ", sottype=" + sottype +
                '}';
    }
}

package com.it.music.entity;

public class Search {
    public int soid;
    public int siid;
    public String soname;
    public String solink;
    public String lyrics;
    public String soimg;
    public String sotime;
    public String publish;
    public int sovip;
    public String siname;

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public int getSiid() {
        return siid;
    }

    public void setSiid(int siid) {
        this.siid = siid;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getSolink() {
        return solink;
    }

    public void setSolink(String solink) {
        this.solink = solink;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getSoimg() {
        return soimg;
    }

    public void setSoimg(String soimg) {
        this.soimg = soimg;
    }

    public String getSotime() {
        return sotime;
    }

    public void setSotime(String sotime) {
        this.sotime = sotime;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getSovip() {
        return sovip;
    }

    public void setSovip(int sovip) {
        this.sovip = sovip;
    }

    public String getSiname() {
        return siname;
    }

    public void setSiname(String siname) {
        this.siname = siname;
    }

    public Search() {
    }

    public Search(int siid, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip, String siname) {
        this.siid = siid;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
        this.siname = siname;
    }

    public Search(int soid, int siid, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip, String siname) {
        this.soid = soid;
        this.siid = siid;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
        this.siname = siname;
    }

    @Override
    public String toString() {
        return "\nSearch{" +
                "soid=" + soid +
                ", siid=" + siid +
                ", soname='" + soname + '\'' +
                ", solink='" + solink + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", soimg='" + soimg + '\'' +
                ", sotime='" + sotime + '\'' +
                ", publish='" + publish + '\'' +
                ", sovip=" + sovip +
                ", siname='" + siname + '\'' +
                '}';
    }
}

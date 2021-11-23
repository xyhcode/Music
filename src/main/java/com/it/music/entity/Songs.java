package com.it.music.entity;

/**
 * @author 羡羡
 * 歌曲
 */
public class Songs {
    public int soid;
    public String siname;
    public String soname;
    public String solink;
    public String lyrics;
    public String soimg;
    public String sotime;
    public String publish;
    public int sovip;

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public String getSiname() {
        return siname;
    }

    public void setSiname(String siname) {
        this.siname = siname;
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

    public Songs() {
    }

    public Songs(String siname, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip) {
        this.siname = siname;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
    }

    public Songs(int soid, String siname, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip) {
        this.soid = soid;
        this.siname = siname;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
    }

    @Override
    public String toString() {
        return "\nSong{" +
                "soid=" + soid +
                ", siname=" + siname +
                ", soname='" + soname + '\'' +
                ", solink='" + solink + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", soimg='" + soimg + '\'' +
                ", sotime='" + sotime + '\'' +
                ", publish='" + publish + '\'' +
                ", sovip=" + sovip +
                '}';
    }
}

package com.it.music.entity;

/**
 * @author 羡羡
 */
public class SongSing {
    public int soid;
    public int siid;
    public String soname;
    public String solink;
    public String lyrics;
    public String soimg;
    public String sotime;
    public String publish;
    public int sovip;
    Singer sing;

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

    public Singer getSing() {
        return sing;
    }

    public void setSing(Singer sing) {
        this.sing = sing;
    }

    public SongSing() {
    }

    public SongSing(int siid, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip, Singer sing) {
        this.siid = siid;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
        this.sing = sing;
    }

    public SongSing(int soid, int siid, String soname, String solink, String lyrics, String soimg, String sotime, String publish, int sovip, Singer sing) {
        this.soid = soid;
        this.siid = siid;
        this.soname = soname;
        this.solink = solink;
        this.lyrics = lyrics;
        this.soimg = soimg;
        this.sotime = sotime;
        this.publish = publish;
        this.sovip = sovip;
        this.sing = sing;
    }

    @Override
    public String toString() {
        return "\nSongSing{" +
                "soid=" + soid +
                ", siid=" + siid +
                ", soname='" + soname + '\'' +
                ", solink='" + solink + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", soimg='" + soimg + '\'' +
                ", sotime='" + sotime + '\'' +
                ", publish='" + publish + '\'' +
                ", sovip=" + sovip +
                ", sing=" + sing +
                '}';
    }
}

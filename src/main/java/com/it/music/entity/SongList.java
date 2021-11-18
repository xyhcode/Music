package com.it.music.entity;

/**
 * @author 羡羡
 */
public class SongList {
    public int solid;
    public String soltitle;
    public String solimg;
    public String soid;
    public int usid;

    public int getSolid() {
        return solid;
    }

    public void setSolid(int solid) {
        this.solid = solid;
    }

    public String getSoltitle() {
        return soltitle;
    }

    public void setSoltitle(String soltitle) {
        this.soltitle = soltitle;
    }

    public String getSolimg() {
        return solimg;
    }

    public void setSolimg(String solimg) {
        this.solimg = solimg;
    }

    public String getSoid() {
        return soid;
    }

    public void setSoid(String soid) {
        this.soid = soid;
    }

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public SongList() {
    }

    public SongList(String soltitle, String solimg, String soid, int usid) {
        this.soltitle = soltitle;
        this.solimg = solimg;
        this.soid = soid;
        this.usid = usid;
    }

    public SongList(int solid, String soltitle, String solimg, String soid, int usid) {
        this.solid = solid;
        this.soltitle = soltitle;
        this.solimg = solimg;
        this.soid = soid;
        this.usid = usid;
    }

    @Override
    public String toString() {
        return "\nSongList{" +
                "solid=" + solid +
                ", soltitle='" + soltitle + '\'' +
                ", solimg='" + solimg + '\'' +
                ", soid='" + soid + '\'' +
                ", usid=" + usid +
                '}';
    }
}

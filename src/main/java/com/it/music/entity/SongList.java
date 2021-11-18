package com.it.music.entity;

/**
 * @author 羡羡
 */
public class SongList {
    public int solid;
    public String soltitle;
    public String solintro;
    public String solimg;
    public String sotid;
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

    public String getSolintro() {
        return solintro;
    }

    public void setSolintro(String solintro) {
        this.solintro = solintro;
    }

    public String getSolimg() {
        return solimg;
    }

    public void setSolimg(String solimg) {
        this.solimg = solimg;
    }

    public String getSotid() {
        return sotid;
    }

    public void setSotid(String sotid) {
        this.sotid = sotid;
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

    public SongList(String soltitle, String solintro, String solimg, String sotid, String soid, int usid) {
        this.soltitle = soltitle;
        this.solintro = solintro;
        this.solimg = solimg;
        this.sotid = sotid;
        this.soid = soid;
        this.usid = usid;
    }

    public SongList(int solid, String soltitle, String solintro, String solimg, String sotid, String soid, int usid) {
        this.solid = solid;
        this.soltitle = soltitle;
        this.solintro = solintro;
        this.solimg = solimg;
        this.sotid = sotid;
        this.soid = soid;
        this.usid = usid;
    }

    @Override
    public String toString() {
        return "\nSongList{" +
                "solid=" + solid +
                ", soltitle='" + soltitle + '\'' +
                ", solintro='" + solintro + '\'' +
                ", solimg='" + solimg + '\'' +
                ", sotid='" + sotid + '\'' +
                ", soid='" + soid + '\'' +
                ", usid=" + usid +
                '}';
    }
}

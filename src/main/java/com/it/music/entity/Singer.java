package com.it.music.entity;

/**
 *
 * 歌手
 */
public class Singer {
    public int siid;
    public String siname;
    public String siintro;
    public String siimg;
    public int siarea;
    public int sitype;


    public int getSiid() {
        return siid;
    }

    public void setSiid(int siid) {
        this.siid = siid;
    }

    public String getSiname() {
        return siname;
    }

    public void setSiname(String siname) {
        this.siname = siname;
    }

    public String getSiintro() {
        return siintro;
    }

    public void setSiintro(String siintro) {
        this.siintro = siintro;
    }

    public String getSiimg() {
        return siimg;
    }

    public void setSiimg(String siimg) {
        this.siimg = siimg;
    }

    public int getSiarea() {
        return siarea;
    }

    public void setSiarea(int siarea) {
        this.siarea = siarea;
    }

    public int getSitype() {
        return sitype;
    }

    public void setSitype(int sitype) {
        this.sitype = sitype;
    }

    public Singer() {
    }

    public Singer(String siname, String siintro, String siimg, int siarea, int sitype) {
        this.siname = siname;
        this.siintro = siintro;
        this.siimg = siimg;
        this.siarea = siarea;
        this.sitype = sitype;
    }

    public Singer(int siid, String siname, String siintro, String siimg, int siarea, int sitype) {
        this.siid = siid;
        this.siname = siname;
        this.siintro = siintro;
        this.siimg = siimg;
        this.siarea = siarea;
        this.sitype = sitype;
    }

    @Override
    public String toString() {
        return "\nSinger{" +
                "siid=" + siid +
                ", siname='" + siname + '\'' +
                ", siintro='" + siintro + '\'' +
                ", siimg='" + siimg + '\'' +
                ", siarea=" + siarea +
                ", sitype=" + sitype +
                '}';
    }
}

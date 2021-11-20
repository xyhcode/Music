package com.it.music.entity;

import java.util.List;

/**
 * @author 羡羡
 */
public class SingerAll {
    public int siid;
    public String siname;
    public String siintro;
    public String siimg;
    public int siarea;
    public int sitype;
    public List<Song> song;

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

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    public SingerAll() {
    }

    public SingerAll(String siname, String siintro, String siimg, int siarea, int sitype, List<Song> song) {
        this.siname = siname;
        this.siintro = siintro;
        this.siimg = siimg;
        this.siarea = siarea;
        this.sitype = sitype;
        this.song = song;
    }

    public SingerAll(int siid, String siname, String siintro, String siimg, int siarea, int sitype, List<Song> song) {
        this.siid = siid;
        this.siname = siname;
        this.siintro = siintro;
        this.siimg = siimg;
        this.siarea = siarea;
        this.sitype = sitype;
        this.song = song;
    }

    @Override
    public String toString() {
        return "SingerAll{" +
                "siid=" + siid +
                ", siname='" + siname + '\'' +
                ", siintro='" + siintro + '\'' +
                ", siimg='" + siimg + '\'' +
                ", siarea=" + siarea +
                ", sitype=" + sitype +
                ", song=" + song +
                '}';
    }
}

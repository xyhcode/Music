package com.it.music.entity;

/**
 * @author 羡羡
 * 视频
 */
public class Feature {
    public int feid;
    public String fetitle;
    public String feurl;
    public int feplays;
    public String cover;

    public int getFeid() {
        return feid;
    }

    public void setFeid(int feid) {
        this.feid = feid;
    }

    public String getFetitle() {
        return fetitle;
    }

    public void setFetitle(String fetitle) {
        this.fetitle = fetitle;
    }

    public String getFeurl() {
        return feurl;
    }

    public void setFeurl(String feurl) {
        this.feurl = feurl;
    }

    public int getFeplays() {
        return feplays;
    }

    public void setFeplays(int feplays) {
        this.feplays = feplays;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Feature() {
    }

    public Feature(String fetitle, String feurl, int feplays, String cover) {
        this.fetitle = fetitle;
        this.feurl = feurl;
        this.feplays = feplays;
        this.cover = cover;
    }

    public Feature(int feid, String fetitle, String feurl, int feplays, String cover) {
        this.feid = feid;
        this.fetitle = fetitle;
        this.feurl = feurl;
        this.feplays = feplays;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "\nFeature{" +
                "feid=" + feid +
                ", fetitle='" + fetitle + '\'' +
                ", feurl='" + feurl + '\'' +
                ", feplays=" + feplays +
                ", cover='" + cover + '\'' +
                '}';
    }
}

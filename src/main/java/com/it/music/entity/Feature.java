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

    public Feature() {
    }

    public Feature(String fetitle, String feurl, int feplays) {
        this.fetitle = fetitle;
        this.feurl = feurl;
        this.feplays = feplays;
    }

    public Feature(int feid, String fetitle, String feurl, int feplays) {
        this.feid = feid;
        this.fetitle = fetitle;
        this.feurl = feurl;
        this.feplays = feplays;
    }

    @Override
    public String toString() {
        return "\nFeature{" +
                "feid=" + feid +
                ", fetitle='" + fetitle + '\'' +
                ", feurl='" + feurl + '\'' +
                ", feplays=" + feplays +
                '}';
    }
}

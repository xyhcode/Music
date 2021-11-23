package com.it.music.entity;

public class Collect {

    private int coid;
    private int usid;
    private int allid;
    private int cotype;
    private String cotime;

    public Collect(int coid, int usid, int allid, int cotype, String cotime) {
        this.coid = coid;
        this.usid = usid;
        this.allid = allid;
        this.cotype = cotype;
        this.cotime = cotime;
    }

    public Collect(int usid, int allid, int cotype, String cotime) {
        this.usid = usid;
        this.allid = allid;
        this.cotype = cotype;
        this.cotime = cotime;
    }

    public Collect() {
    }

    @Override
    public String toString() {
        return "\nCollect{" +
                "coid=" + coid +
                ", usid=" + usid +
                ", allid=" + allid +
                ", cotype=" + cotype +
                ", cotime='" + cotime + '\'' +
                '}';
    }

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public int getAllid() {
        return allid;
    }

    public void setAllid(int allid) {
        this.allid = allid;
    }

    public int getCotype() {
        return cotype;
    }

    public void setCotype(int cotype) {
        this.cotype = cotype;
    }

    public String getCotime() {
        return cotime;
    }

    public void setCotime(String cotime) {
        this.cotime = cotime;
    }
}

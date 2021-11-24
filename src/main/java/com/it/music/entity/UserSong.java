package com.it.music.entity;

import lombok.Data;

/**
 * 播放表entity
 */
public class UserSong {

    public int usid;
    public int soid;

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public int getSoid() {
        return soid;
    }

    public void setSoid(int soid) {
        this.soid = soid;
    }

    public UserSong(){

    }

    public UserSong(int usid, int soid) {
        this.usid = usid;
        this.soid = soid;
    }

    @Override
    public String toString() {
        return "UserSong{" +
                "usid=" + usid +
                ", soid=" + soid +
                '}';
    }
}

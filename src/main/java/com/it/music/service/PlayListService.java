package com.it.music.service;

import com.it.music.entity.SongSing;
import com.it.music.entity.UserSong;

import java.util.List;

public interface PlayListService {

    public List getSongList(int uid);

    public SongSing getSong(int sid);

    public List getSongs();

    public int addSong(UserSong us);

    public UserSong selectSong(UserSong us);

    public int insertSongs(int uid,String[] str);

    public String[] getSingerSoid(int siid);

    public List getCollectList(int uid);

    public int delSong(UserSong us);

    public int delAllSong(int uid);
}

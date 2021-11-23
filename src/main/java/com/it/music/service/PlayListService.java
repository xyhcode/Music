package com.it.music.service;

import com.it.music.entity.SongSing;

import java.util.List;

public interface PlayListService {

    public List getSongList(int uid);

    public SongSing getSong(int sid);

    public List getSongs();
}

package com.it.music.service.impl;

import com.it.music.dao.PlayListDao;
import com.it.music.entity.SongSing;
import com.it.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListServiceimpl implements PlayListService {

    @Autowired
    PlayListDao playListDao;

    /**
     * 查播放表所有歌曲
     * @param uid
     * @return
     */
    @Override
    public List getSongList(int uid) {
        return playListDao.getSongList(uid);
    }

    @Override
    public SongSing getSong(int sid) {
        return playListDao.getSong(sid);
    }

    @Override
    public List getSongs() {
        return playListDao.getSongs();
    }
}

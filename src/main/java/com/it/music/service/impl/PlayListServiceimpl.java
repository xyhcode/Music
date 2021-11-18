package com.it.music.service.impl;

import com.it.music.dao.PlayListDao;
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
}

package com.it.music.service.impl;

import com.it.music.dao.SongNumDao;
import com.it.music.entity.SongNum;
import com.it.music.service.SongNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongNumServiceimpl implements SongNumService {

    @Autowired
    SongNumDao songNumDao;

    @Override
    public int add(SongNum sn) {
        return songNumDao.adds(sn);
    }
}

package com.it.music.service.impl;

import com.it.music.dao.SongTypeDao;
import com.it.music.service.SongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongTypeServiceimpl implements SongTypeService {

    @Autowired
    SongTypeDao sot;

    @Override
    public List sein() {
        List lis=sot.sein();
        return lis;
    }

    @Override
    public List seall(int sottype) {
        List lis=sot.seall(sottype);
        return lis;
    }
}

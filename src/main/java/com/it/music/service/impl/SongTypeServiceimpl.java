package com.it.music.service.impl;

import com.it.music.dao.SongTypeDao;
import com.it.music.entity.SongType;
import com.it.music.service.SongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lingjing
 */
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

    @Override
    public SongType getSongType(int sotid) {
        return sot.getSongType(sotid);
    }

    @Override
    public Object[] setype() {

        Object[] obj = new Object[6];
        for(int i=1;i<obj.length;i++){
            obj[i] = sot.seall(i);
        }
        return obj;
    }
}

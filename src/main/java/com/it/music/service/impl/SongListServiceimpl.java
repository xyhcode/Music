package com.it.music.service.impl;

import com.it.music.dao.SongListDao;
import com.it.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 羡羡
 */
@Service
public class SongListServiceimpl implements SongListService {

    @Autowired
    SongListDao solidao;

    @Override
    public List seind() {
        List lis=solidao.seind();
        return lis;
    }

    @Override
    public List seall() {
        List lis=solidao.seall();
        return lis;
    }
}

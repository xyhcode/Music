package com.it.music.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.dao.SongListDao;
import com.it.music.entity.SongList;
import com.it.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author lingjing
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

    @Override
    public SongList getSongList(int solid) {
        return solidao.getSongList(solid);
    }

    @Override
    public PageInfo solall(int p) {
        //分页  当前1页  每页10条
        PageHelper.startPage(p,10);
        List list = solidao.seall();
        PageInfo page = new PageInfo(list,7);
        return page;
    }

    @Override
    public PageInfo solall(int sotid, int p) {
        //分页  当前1页  每页10条
        PageHelper.startPage(p,10);
        List list = solidao.solall(sotid);
        PageInfo page = new PageInfo(list,7);
        return page;
    }
}

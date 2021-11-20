package com.it.music.service.impl;

import com.it.music.dao.SingerDao;
import com.it.music.entity.Singer;
import com.it.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 羡羡
 */
@Service
public class SingerServiceimpl implements SingerService {

    @Autowired
    SingerDao sing;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List seall() {
        List lis=sing.seall();
        return lis;
    }

    /**
     * 歌手添加
     * @param sin
     * @return
     */
    @Override
    public int singadd(Singer sin) {
        int sinad=sing.singadd(sin);
        return sinad;
    }

    @Override
    public List seindx() {
        List ls=sing.seindx();
        return ls;
    }

    @Override
    public Singer getSinger(int siid) {
        return sing.getSinger(siid);
    }
}

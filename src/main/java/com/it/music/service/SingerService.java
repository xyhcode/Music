package com.it.music.service;

import com.it.music.entity.Singer;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SingerService {

    /**
     * 查询所有歌手
     * @return
     */
    public List seall();

    /**
     * 歌手添加
     * @param sin
     * @return
     */
    public int singadd(Singer sin);
}

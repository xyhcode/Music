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

    /**
     * 查询所有显示首页随机
     * @return
     */
    public List seindx();

    /**
     * 根据歌手ID查询歌手
     * @param siid
     * @return
     */
    public Singer getSinger(int siid);
}

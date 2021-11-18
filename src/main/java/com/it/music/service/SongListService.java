package com.it.music.service;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SongListService {

    /**
     * 随机查询首页的数据
     * @return
     */
    public List seind();

    /**
     * 查询所有
     * @return
     */
    public List seall();
}

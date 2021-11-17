package com.it.music.service;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SongTypeService {
    /**
     * 查询首页的歌单类型11
     * @return
     */
    public List sein();

    /**
     * 查询指定的分类
     * @param sottype
     * @return
     */
    public List seall(int sottype);
}

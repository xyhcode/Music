package com.it.music.service;


import com.it.music.entity.SongType;

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


    /**
     * 根据id查询指定类
     * @param sotid
     * @return
     */
    public SongType getSongType(int sotid);

    /**
     * 显示歌单类型
     * @return
     */
    public Object[] setype();

}

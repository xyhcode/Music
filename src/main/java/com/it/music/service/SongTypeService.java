package com.it.music.service;


import com.it.music.entity.SongType;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SongTypeService {
    /**
     * 查询所有类型
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

    /**
     * 分类增加
     */
        public int addclass(SongType stype);

    /**
     * 删除分类
     */
    public int delclass(int sotid);
    /**
     * 修改分类
     */
    public int updateclass(SongType stype);
}

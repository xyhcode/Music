package com.it.music.dao;

import com.it.music.entity.SongType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface SongTypeDao {

    /**
     * 查询首页的歌单类型11
     * @return
     */
    public List sein();

    /**
     * 查询指定的父分类
     * @param sottype 1种语、2流派、3主题、4感情、5场景
     * @return
     */
    public List seall(int sottype);

    /**
     * 根据id查询指定类
     * @param sotid
     * @return
     */
    public SongType getSongType(int sotid);

}

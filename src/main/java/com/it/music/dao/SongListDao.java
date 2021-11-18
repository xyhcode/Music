package com.it.music.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface SongListDao {
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

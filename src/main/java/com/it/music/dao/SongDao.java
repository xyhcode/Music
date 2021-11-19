package com.it.music.dao;

import com.it.music.entity.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface SongDao {
    /**
     * 查询所有
     * @return
     */
    public List seall();

    /**
     * 添加
     * @param son
     * @return
     */
    public int songadd(Song son);


    /**
     * 所有随机查询
     * @return
     */
    public List seind();

    /**
     * 所有查询歌对应的歌手
     * @return
     */
    public List songseing();
}
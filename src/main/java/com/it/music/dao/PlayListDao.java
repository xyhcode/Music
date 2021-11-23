package com.it.music.dao;

import com.it.music.entity.SongSing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 播放表
 */
@Mapper
public interface PlayListDao {

    //根据用户id查播放列表
    public List getSongList(int uid);

    //根据歌曲id查歌曲信息
    public SongSing getSong(int soid);

    //查所有歌曲
    public List getSongs();

}

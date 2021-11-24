package com.it.music.dao;

import com.it.music.entity.SongSing;
import com.it.music.entity.UserSong;
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

    //添加单首歌到播放列表
    public int addSong(UserSong us);

    //查这首歌是否存在
    public UserSong selectSong(UserSong us);

    //查歌手的所有歌曲
    public List findSingerSong(int siid);

}

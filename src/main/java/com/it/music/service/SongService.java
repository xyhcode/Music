package com.it.music.service;

import com.it.music.entity.SingerAll;
import com.it.music.entity.Song;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SongService {
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
     * 根据歌手ID查询歌曲
     * @return
     */
    public List issinger(int siid);

    /**
     * 根据歌曲ID查询歌曲
     * @param soid
     * @return
     */
    public Song getSong(int soid);

    /**
     * 所有查询歌对应的歌手
     * @return
     */
    public List songseing();

    /**
     * 根据多个ID查询多个歌曲
     * @param soid
     * @return
     */
    public List getSongAll(String[] soid);

    /**
     * 查询指定歌手的歌
     * @return
     */
    public SingerAll singerallsong(int siid);


    /**
     * 搜索歌
     * @return
     */
    public List searchdong(String soname);

    /**
     * 删除歌
     * @return
     */
    public int del(int soid);
    /**
     * 根据歌曲id查询
     * @return
     */
    public Song find(int soid);

    /**
     * 修改
     * @param song
     * @return
     */
    public int  update(Song song);


    /**
     * 统计所有的歌曲的数量
     * @return
     */
    public int secount();
}

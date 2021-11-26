package com.it.music.service;

import com.github.pagehelper.PageInfo;
import com.it.music.entity.SongList;

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

    /**
     * 根据id查询歌单
     * @param solid
     * @return
     */
    public SongList getSongList(int solid);

    /**
     * 分页显示歌单
     * @param p
     * @return
     */
    public PageInfo solall(int p);

    /**
     * 根据类型 分页显示歌单
     * @param sotid
     * @param p
     * @return
     */
    public PageInfo solall(int sotid,int p);

    /***
     * 查询所有的歌单的总数
     * @return
     */
    public int solicount();

    /**
     * 查询所有歌曲是VIP的歌单
     * @return
     */
    public List vipall();


}

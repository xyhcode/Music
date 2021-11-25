package com.it.music.dao;

import com.it.music.entity.SongList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lingjing
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

    /**
     * 根据id查询歌单
     * @param solid
     * @return
     */
    public SongList getSongList(int solid);


    /**
     * 根据ID查询所有
     * @param sotid
     * @return
     */
    public List solall(int sotid);

    /**
     * 查询歌单的总数
     * @return
     */
    public int solicount();

}

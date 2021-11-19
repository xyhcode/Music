package com.it.music.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

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
}

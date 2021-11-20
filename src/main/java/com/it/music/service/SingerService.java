package com.it.music.service;

import com.it.music.entity.Singer;

import java.util.List;

/**
 * @author 羡羡
 */
public interface SingerService {

    /**
     * 查询所有歌手
     * @return
     */
    public List seall();

    /**
     * 歌手添加
     * @param sin
     * @return
     */
    public int singadd(Singer sin);

    /**
     * 查询所有显示首页随机
     * @return
     */
    public List seindx();

    /**
     * 根据歌手ID查询歌手
     * @param siid
     * @return
     */
    public Singer getSinger(int siid);


    /**
     * 查询字母
     * @param firstle
     * @return
     */
    public List  morsinger(String firstle,int dq,int lb);

    /**
     * 查询地区
     * @param siarea
     * @return
     */
    public List sedq(int siarea);

    /**
     * 查询类型
     * @param sitype
     * @return
     */
    public List sety(int sitype);

    /**
     * 类型地区联合查
     * @param sin
     * @return
     */
    public List sedqty(Singer sin);

    public List seallsing();

}

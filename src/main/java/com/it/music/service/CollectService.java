package com.it.music.service;

import com.it.music.entity.Collect;
import com.it.music.entity.CollectCount;
import com.it.music.entity.SongSing;

import java.util.List;
import java.util.Map;

/**
 * @author lingjing
 */
public interface CollectService {

    /**
     * 根据用户 和类型查询 收藏
     * @param usid
     * @param type
     * @return
     */
    public List showxx(int usid,int type);

    /**
     * 根据用户 和类型查询 收藏
     * @param usid
     * @param type
     * @return
     */
    public List showdata(int usid,int type);


    /**
     * 取消收藏
     * @param coid
     * @return
     */
    public  int del(int coid);

    /**
     * 收藏
     * @param collect
     * @return
     */
    public int add(Collect collect);

    /**
     * 找
     * @param usid
     * @param allid
     * @return
     */
    public Collect zao(int usid ,int allid);

    /**
     * 用户id找所有收藏歌曲的id
     * @param uid
     * @return
     */
    public String[] findColl(int uid);

    /**
     * 统计收藏
     * @param usid
     * @return
     */
    public CollectCount count(int usid);

    /**
     * 根据用户id 查询 收藏
     * @param usid
     * @return
     */
    public List show1(int usid);
    public List show2(int usid);
    public List show3(int usid);

}

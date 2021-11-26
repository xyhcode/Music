package com.it.music.dao;

import com.it.music.entity.Collect;
import com.it.music.entity.CollectCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lingjing
 */
@Mapper
public interface CollectDao {

    /**
     * 根据用户 和类型查询 收藏
     * @param collect
     * @return
     */
    public List showxx(Collect collect);

    /**
     * 取消收藏
     * @param coid
     * @return
     */
    public  int del(int coid);

    /**
     * 找
     * @param collect
     * @return
     */
    public Collect zao(Collect collect);

    /**
     * 收藏
     * @param collect
     * @return
     */
    public int add(Collect collect);

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

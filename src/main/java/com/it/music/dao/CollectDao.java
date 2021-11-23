package com.it.music.dao;

import com.it.music.entity.Collect;
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

}

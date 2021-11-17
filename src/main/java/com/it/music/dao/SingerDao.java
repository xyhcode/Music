package com.it.music.dao;

import com.it.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 */
@Mapper
public interface SingerDao {
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
}

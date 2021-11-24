package com.it.music.dao;

import com.it.music.entity.SongNum;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongNumDao {

    public int adds(SongNum sn);

}

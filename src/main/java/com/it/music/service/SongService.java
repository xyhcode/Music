package com.it.music.service;

import com.it.music.entity.Song;
import org.springframework.stereotype.Service;

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
}

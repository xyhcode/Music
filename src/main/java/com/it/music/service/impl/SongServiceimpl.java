package com.it.music.service.impl;

import com.it.music.dao.SongDao;
import com.it.music.entity.SingerAll;
import com.it.music.entity.Song;
import com.it.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 羡羡
 */
@Service
public class SongServiceimpl implements SongService {

    @Autowired
    SongDao sodao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List seall() {
        List lis= sodao.seall();
        return lis;
    }

    @Override
    public Song getSong(int soid) {
        return sodao.getSong(soid);
    }


    /**
     * 添加歌曲
     * @param son
     * @return
     */
    @Override
    public int songadd(Song son) {
        int soad=sodao.songadd(son);
        return soad;
    }

    /**
     * 所有随机查询
     * @return
     */
    @Override
    public List seind() {
        List lis=sodao.seind();
        return lis;
    }

    @Override
    public List songseing() {
        List lis=sodao.songseing();
        return lis;
    }

    @Override
    public List getSongAll(String[] soid) {
        return sodao.getSongAll(soid);
    }

    @Override
    public SingerAll singerallsong(int siid) {
        SingerAll lis=sodao.singerallsong(siid);
        return lis;
    }

    @Override
    public List searchdong(String soname) {
        List lis=sodao.searchdong(soname);
        return lis;
    }
}

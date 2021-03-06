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
    public List issinger(int siid) {
        return sodao.issinger(siid);
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

    /**
     * 删除
     * @param soid
     * @return
     */
    @Override
    public int del(int soid) {
        int i=sodao.del(soid);
        return i;
    }
    /**
     * 根据歌曲id查询
     * @param soid
     * @return
     */
    @Override
    public Song find(int soid) {
        Song song= sodao.find(soid);
        return song;
    }

    @Override
    public int update(Song song) {
        int i=sodao.update(song);
        return i;
    }



    /**
     * 统计所有歌曲的总数
     * @return
     */
    @Override
    public int secount() {
        int coun=sodao.secount();
        return coun;
    }


}

package com.it.music.service.impl;

import com.it.music.dao.*;
import com.it.music.entity.Collect;
import com.it.music.entity.Singer;
import com.it.music.entity.Song;
import com.it.music.entity.Songs;
import com.it.music.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjing
 */
@Service
public class CollectServiceimp implements CollectService {

    @Autowired
    CollectDao collectDao;

    @Autowired
    SongDao songDao;

    @Autowired
    SingerDao singerDao;

    @Autowired
    SongListDao songListDao;

    @Autowired
    FeatureDao featureDao;

    @Override
    public List showxx(int usid, int type) {
        Collect collect = new Collect();
        collect.setUsid(usid);
        collect.setCotype(type);
        return collectDao.showxx(collect);
    }

    @Override
    public List showdata(int usid, int type) {
        Collect collect = new Collect();
        collect.setUsid(usid);
        collect.setCotype(type);
        //指定类型所有收藏
        List ls = collectDao.showxx(collect);
        List list = new ArrayList();

        switch(type){
            //歌曲
            case 1:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    Song so = songDao.getSong(col.getAllid());
                    for(int j=0;j<singerDao.seall().size();j++){
                        Singer sin = (Singer) singerDao.seall().get(j);
                        if(sin.getSiid()==so.getSiid()){
                            Songs sos = new Songs(so.getSoid(),sin.getSiname(),so.getSoname(),so.getSolink(),so.getLyrics(),so.getSoimg(),so.getSotime(),so.getPublish(),so.getSovip());
                            list.add(sos);
                        }
                    }
                }
            }break;
            //歌单
            case 2:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    list.add(songListDao.getSongList(col.getAllid()));
                }
            }break;
            //视频
            case 3:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    list.add(featureDao.findidvoid(col.getAllid()));
                }
            }break;
            default: System.out.println("type:"+type);
        }

        return list;
    }

    @Override
    public int del(int coid) {
        return collectDao.del(coid);
    }

    @Override
    public int add(Collect collect) {
        return collectDao.add(collect);
    }

    @Override
    public Collect zao(int usid, int allid) {
        Collect collect = new Collect();
        collect.setUsid(usid);
        collect.setAllid(allid);
        return collectDao.zao(collect);
    }

    @Override
    public String[] findColl(int uid) {
        List list=collectDao.showxx(new Collect(uid,1));
        String[] str=new String[list.size()];
        for (int i=0;i<str.length;i++){
            Collect z=(Collect) list.get(i);
            str[i]=""+z.getAllid();
        }
        return str;
    }

}

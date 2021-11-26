package com.it.music;

import com.it.music.dao.CollectDao;
import com.it.music.dao.SingerDao;
import com.it.music.dao.SongDao;
import com.it.music.entity.*;
import com.it.music.service.CollectService;
import com.it.music.service.SingerService;
import com.it.music.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class CollectTest {

    @Autowired
    CollectDao collectDao;

    @Autowired
    SongDao songDao;

    @Autowired
    SingerDao singerDao;


    @Test
    public void t(){
        Collect collect = new Collect();
        collect.setUsid(1001);
        collect.setCotype(1);
        List list = collectDao.showxx(collect);
        System.out.println(list);
    }

    @Test
    public void tt(){

        Collect collect = new Collect();
        collect.setUsid(1001);
        collect.setCotype(1);
        List ls = collectDao.showxx(collect);
        List list = new ArrayList();
        System.out.println("sl:"+ls);

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

        System.out.println("show:"+list);

    }

    @Test
    public void t2(){

        CollectCount cc = collectDao.count(1001);
        System.out.println(cc);

    }

    @Test
    public void t3(){

        List list = collectDao.show1(1001);
        System.out.println(list);

    }

}

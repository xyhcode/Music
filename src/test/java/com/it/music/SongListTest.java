package com.it.music;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.dao.SongListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SongListTest {

    @Autowired
    SongListDao songListDao;

    @Test
    public void sein(){
        List lis= songListDao.seind();
        System.out.println(lis);
    }


    @Test
    public void seall(){
        List lis=songListDao.seall();
        System.out.println(lis);
    }



    @Test
    public void t3(){

        //分页  当前1页  每页10条
        PageHelper.startPage(1,10);
        List list = songListDao.solall(224);
        PageInfo page = new PageInfo(list,10);
        System.out.println(page);
    }


    @Test
    public void sol(){
        int solont=songListDao.solicount();
        System.out.println(solont);
    }

}

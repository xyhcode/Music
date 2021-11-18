package com.it.music;

import com.it.music.dao.SongListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SongListTest {


    @Autowired
    SongListDao songlidao;

    @Test
    public void sein(){
       List lis= songlidao.seind();
       System.out.println(lis);
    }


    @Test
    public void seall(){
        List lis=songlidao.seall();
        System.out.println(lis);
    }

}

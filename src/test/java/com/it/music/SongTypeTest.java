package com.it.music;

import com.it.music.dao.SongTypeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SongTypeTest {

    @Autowired
    SongTypeDao soty;


    @Test
    public void sein(){
        List lis=soty.sein();
        System.out.println(lis);
    }

    @Test
    public void seall(){
        List lis=soty.seall(1);
        System.out.println(lis);
    }
}

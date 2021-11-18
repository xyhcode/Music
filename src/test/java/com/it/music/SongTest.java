package com.it.music;

import com.it.music.dao.SongDao;
import com.it.music.entity.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SongTest {

    @Autowired
    SongDao sodao;

    @Test
    public void seall(){
        List lis=sodao.seall();
        System.out.println(lis);
    }

    @Test
    public void soadd(){
        Song so=new Song(345,"测试","https://","htpps://","https://","05:04","2021/11/1",0);
        int f=sodao.songadd(so);
        System.out.println(f);
    }

    @Test
    public void sonser(){
        List lis=sodao.songseing();
        System.out.println(lis);
    }
}

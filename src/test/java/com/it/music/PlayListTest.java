package com.it.music;

import com.it.music.dao.PlayListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlayListTest {

    @Autowired
    PlayListDao playListDao;

    @Test
    public void getSongList(){
        List list=playListDao.getSongList(1001);
        System.out.println(list);
    }
}

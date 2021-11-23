package com.it.music;

import com.it.music.dao.PlayListDao;
import com.it.music.entity.SongSing;
import com.it.music.tools.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
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

    @Test
    public void getSong(){
        SongSing s=playListDao.getSong(254);
        System.out.println(s.getSing().siname);
    }

    @Test
    public void getSongs(){
        List lists=playListDao.getSongs();
        System.out.println(lists);
    }

    @Test
    public void gc() throws IOException {
        String s= JsonUtil.getjson("https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/lrc/1637048331778.txt");
        System.out.println(s);
    }
}

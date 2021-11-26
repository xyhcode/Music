package com.it.music;

import com.it.music.dao.PlayListDao;
import com.it.music.entity.Song;
import com.it.music.entity.SongSing;
import com.it.music.entity.UserSong;
import com.it.music.service.PlayListService;
import com.it.music.service.impl.PlayListServiceimpl;
import com.it.music.tools.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
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

    @Test
    public void g() throws IOException {
        List list=playListDao.findSingerSong(345);
        System.out.println(list);
        String[] str=new String[list.size()];
        for (int i=0;i< list.size();i++){
            Song z=(Song) list.get(i);
            str[i]=""+z.soid;
        }
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void z(){
        int n=playListDao.delAllSong(1004);
        System.out.println(n);
    }
}

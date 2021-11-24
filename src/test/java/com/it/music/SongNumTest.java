package com.it.music;

import com.it.music.dao.SongNumDao;
import com.it.music.entity.SongNum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootTest
public class SongNumTest {

    @Autowired
    SongNumDao songNumDao;

    @Test
    public void s(){
        Date data=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dtime=sdf.format(data);
        SongNum s=new SongNum(1004,285,dtime);
        System.out.println(s);
        int n=songNumDao.adds(s);
        System.out.println(n);
    }
}

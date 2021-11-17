package com.it.music;

import com.it.music.dao.SingerDao;
import com.it.music.entity.Singer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SingerTest {

    @Autowired
    SingerDao sind;

    @Test
    public void seall(){
       List lis= sind.seall();
       System.out.println(lis);
    }


    @Test
    public void sinadd(){
        Singer sin=new Singer("易烊千玺","很垃圾","https://",2,1);
        int a=sind.singadd(sin);
        System.out.println(a);
    }
}

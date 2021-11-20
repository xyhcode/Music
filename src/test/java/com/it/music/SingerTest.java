package com.it.music;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.it.music.dao.SingerDao;
import com.it.music.entity.Singer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

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

    @Test
    public void seinde(){
       List lis= sind.seindx();
       System.out.println(lis);
    }

    @Test
    public void testpy(){
        String cf="林俊杰";
        String name=cf.substring(0,1);
        System.out.println(name);
        String result = PinyinUtil.getFirstLetter(name,",");
        String firstLetter=result.toUpperCase();
        System.out.println(firstLetter+" "+"L");
    }

    @Test
    public void testsedq(){
       List lis= sind.sedq(2);
       System.out.println(lis);
    }

    @Test
    public void testsety(){
        List lis=sind.sety(1);
        System.out.println(lis);
    }

    @Test
    public void testsedqty(){
        Singer si=new Singer();
        si.setSiarea(2);
        si.setSitype(1);
        List lis=sind.sedqty(si);
        System.out.println(lis);
    }


    @Test
    public void test1(){
        List lis=sind.seallsing();
        System.out.println(lis);
    }
}

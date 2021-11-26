package com.it.music;

import cn.hutool.core.date.DateUtil;
import com.it.music.dao.SongNumDao;
import com.it.music.entity.SongNum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void sh(){
        int ch=songNumDao.sedat("2021-11-24");
        System.out.println(ch);
    }


    @Test
    public void tes1(){
        List li=new ArrayList();
        Date da=new Date();
        int year=  DateUtil.year(da);
        int fj=DateUtil.month(da);
        String formatDate = DateUtil.formatDate(da);
        String bengday=formatDate.substring(8,10);
        int bemo=Integer.parseInt(bengday);
        String cf;
        for(int i=1;i<=bemo;i++){
            if(i<10){
                cf="0"+i;
            }else {
                cf=i+"";
            }
            String time=year+"-"+(fj+1)+"-"+cf;
            int coun=songNumDao.sedat(time);
            li.add(coun);
        }
        System.out.println(li);
    }
}

package com.it.music;

import com.it.music.dao.FeatureDao;
import com.it.music.entity.Feature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FeatureTest {

    @Autowired
    FeatureDao fe;

    @Test
    public void seall(){
        List lis=fe.sefe();
        System.out.println(lis);
    }

    @Test
    public void inadd(){
        Feature fer=new Feature("测试","https://",167,"");
        int ad=fe.inadd(fer);
        System.out.println(ad);
    }


    @Test
    public void feinde(){
        List lis=fe.seindex();
        System.out.println(lis);
    }


    @Test
    public void findinvoid(){
       Feature fea=fe.findidvoid(1002);
       System.out.println(fea);
    }

    @Test
    public void fecoun(){
        int fcou=fe.fecount();
        System.out.println(fcou);
    }

    @Test
    public void tt(){
        int is =fe.browse(1002);
        System.out.println(is);
    }

}

package com.it.music;

import cn.hutool.core.date.DateUtil;
import com.it.music.dao.PayLogDao;
import com.it.music.entity.PayLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/08:42
 */
@SpringBootTest
public class PayLogTest {

    @Autowired
    PayLogDao paydao;

    @Test
    public void payadd(){
        PayLog pa=new PayLog(1,"100","122121","1212121","20201");
       int cf= paydao.paylogadd(pa);
       System.out.println(cf);
    }

    @Test
    public void payamtcount(){
        int bg=paydao.pacount("2021-11-24");

        System.out.println(bg);
    }

    @Test
    public void paycharts(){
        List lis=new ArrayList();
        Date da=new Date();
        int year= DateUtil.year(da);
        int month=DateUtil.month(da);
        String format=DateUtil.formatDate(da);
        String benbody=format.substring(8,10);
        int bn=Integer.parseInt(benbody);
        String res;
        for(int i=1;i<=bn;i++){
            if(i<10){
                res="0"+i;
            }else{
                res=i+"";
            }
            String time=year+"-"+(month+1)+"-"+res;
            int cf=paydao.pacount(time);
           System.out.println(i+"号："+cf);
        }
    }


    @Test
    public void seall(){
        List is=paydao.sepaylog();
        System.out.println(is);
    }
}

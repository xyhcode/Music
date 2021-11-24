package com.it.music;

import com.it.music.dao.PayLogDao;
import com.it.music.entity.PayLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

package com.it.music;

import com.it.music.dao.UserDao;
import com.it.music.entity.User;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserDao us;

    @Test
    public void seone(){
       User usd= us.seone(1);
       System.out.println(usd);
    }

    @Test
    public void dd(){
//        CosFileupload.delfile("music/img/1637562837466.jpg");

        User user = us.seone(1001);
        String url = user.getUsimg();
        System.out.println(url.substring(url.indexOf("music/img/"),url.length()));




    }

    @Test
    public void seiph(){
        User usc=us.seiphone("17507328304");
        System.out.println(usc);
    }

    @Test
    public void addus(){
        User usad=new User("",0,0,"18379762852","123456","这个人很懒","https://",0,"");
        int uad=us.Userreg(usad);
        System.out.println(uad);
    }

    @Test
    public void rand(){
        String vg= RandomStringUtils.randomAlphanumeric(8);
        System.out.println(vg);
    }

    @Test
    public void rea(){
        int usco=us.uscount();
        System.out.println(usco);
    }
}

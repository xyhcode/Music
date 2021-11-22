package com.it.music;

import com.it.music.dao.UserDao;
import com.it.music.entity.User;
import com.it.music.tools.CosFileupload;
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
}

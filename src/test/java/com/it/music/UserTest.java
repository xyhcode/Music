package com.it.music;

import com.it.music.dao.UserDao;
import com.it.music.entity.User;
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
}

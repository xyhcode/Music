package com.it.music.service.impl;

import com.it.music.dao.UserDao;
import com.it.music.entity.User;
import com.it.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 羡羡
 */
@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserDao usdao;

    @Override
    public User seone(int id) {
        User li=usdao.seone(id);
        return li;
    }

    @Override
    public User login(User user) {
        return usdao.login(user);
    }

    @Override
    public int alter(User user) {
        return usdao.alter(user);
    }
}

package com.it.music.service;

import com.it.music.entity.User;

/**
 * @author 羡羡
 *
 * 用户service
 */
public interface UserService {
    public User seone(int id);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);
}

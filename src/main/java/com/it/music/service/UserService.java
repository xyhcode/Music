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

    public int vercode(String iphone);

    /**
     * 用户注册
     * @param us
     * @return
     */
    public int Userreg(User us);

    /**
     * 电话查询
     * @param iphone
     * @return
     */
    public User seiphone(String iphone);

    /**
     * 用户修改
     * @param user
     * @return
     */
    public int alter(User user);

    /**
     * 用户统计
     * @return
     */
    public int uscou();

}

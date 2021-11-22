package com.it.music.dao;

import com.it.music.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 羡羡
 *
 * 用户dao
 */

@Mapper
public interface UserDao {
    /**
     * 查询指定用户
     * @param id 用户ID
     * @return
     */
    public User seone(int id);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 用户修改
     * @param user
     * @return
     */
    public int alter(User user);


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
}

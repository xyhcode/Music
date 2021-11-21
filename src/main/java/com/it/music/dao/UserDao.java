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

}

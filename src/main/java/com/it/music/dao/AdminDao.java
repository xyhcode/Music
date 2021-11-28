package com.it.music.dao;

import com.it.music.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lingjing
 */
@Mapper
public interface AdminDao {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);
}

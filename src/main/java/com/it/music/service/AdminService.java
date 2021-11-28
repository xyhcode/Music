package com.it.music.service;

import com.it.music.entity.Admin;

/**
 * @author lingjing
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);
}

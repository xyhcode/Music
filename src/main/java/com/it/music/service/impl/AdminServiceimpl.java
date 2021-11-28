package com.it.music.service.impl;

import com.it.music.dao.AdminDao;
import com.it.music.entity.Admin;
import com.it.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lingjing
 */
@Service
public class AdminServiceimpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.login(admin);
    }
}

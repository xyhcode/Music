package com.it.music.service.impl;

import com.it.music.dao.PayLogDao;
import com.it.music.entity.PayLog;
import com.it.music.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/08:40
 */
@Service
public class PayLogServiceimpl implements PayLogService {

    @Autowired
    PayLogDao paydao;

    @Override
    public int paylogadd(PayLog paylog) {
        int n=paydao.paylogadd(paylog);
        return n;
    }
}

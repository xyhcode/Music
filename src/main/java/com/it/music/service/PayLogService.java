package com.it.music.service;

import com.it.music.entity.PayLog;

import java.util.List;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/08:40
 */
public interface PayLogService {
    /**
     * 添加日志
     * @param paylog
     * @return
     */
    public int paylogadd(PayLog paylog);

    public List pacount();
}

package com.it.music.dao;

import com.it.music.entity.PayLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/08:39
 */
@Mapper
public interface PayLogDao {
    /**
     * 添加日志
     * @param paylog
     * @return
     */
    public int paylogadd(PayLog paylog);
}

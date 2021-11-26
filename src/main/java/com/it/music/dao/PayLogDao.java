package com.it.music.dao;

import com.it.music.entity.PayLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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


    /**
     * 得到每天的收益
     * @param time
     * @return
     */
    public int pacount(String time);

    /**
     * 查询所有的支付信息
     * @return
     */
    public List sepaylog();
}

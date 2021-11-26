package com.it.music.service.impl;

import cn.hutool.core.date.DateUtil;
import com.it.music.dao.PayLogDao;
import com.it.music.entity.PayLog;
import com.it.music.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    /**
     * 计算每天的收益
     * @return
     */
    @Override
    public List pacount() {
        List lis=new ArrayList();
        Date da=new Date();
        int year= DateUtil.year(da);
        int month=DateUtil.month(da);
        String format=DateUtil.formatDate(da);
        String benbody=format.substring(8,10);
        int bn=Integer.parseInt(benbody);
        String res;
        for(int i=1;i<=bn;i++){
            if(i<10){
                res="0"+i;
            }else{
                res=i+"";
            }
            String time=year+"-"+(month+1)+"-"+res;
            int amtcoun=paydao.pacount(time);
            lis.add(amtcoun);
        }
        return lis;
    }

    @Override
    public List sepaylog() {
        List lis= paydao.sepaylog();
        return lis;
    }
}

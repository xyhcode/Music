package com.it.music.service.impl;

import cn.hutool.core.date.DateUtil;
import com.it.music.dao.SongNumDao;
import com.it.music.entity.SongNum;
import com.it.music.service.SongNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SongNumServiceimpl implements SongNumService {

    @Autowired
    SongNumDao songNumDao;

    @Override
    public int add(SongNum sn) {
        return songNumDao.adds(sn);
    }

    /**
     * 得到从当前月1号到现在每天的数据
     * @return
     */
    @Override
    public List sedat() {
        List li=new ArrayList();
        Date da=new Date();
        int year=  DateUtil.year(da);
        int fj=DateUtil.month(da);
        String formatDate = DateUtil.formatDate(da);
        String bengday=formatDate.substring(8,10);
        int bemo=Integer.parseInt(bengday);
        String cf;
        for(int i=1;i<=bemo;i++){
            if(i<10){
                cf="0"+i;
            }else {
                cf=i+"";
            }
            String time=year+"-"+(fj+1)+"-"+cf;
            int coun=songNumDao.sedat(time);
            li.add(coun);
        }
        return li;
    }
}

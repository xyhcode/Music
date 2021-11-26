package com.it.music.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.dao.SongDao;
import com.it.music.dao.SongListDao;
import com.it.music.entity.Song;
import com.it.music.entity.SongList;
import com.it.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lingjing
 */

@Service
public class SongListServiceimpl implements SongListService {

    @Autowired
    SongListDao solidao;

    @Autowired
    SongDao songDao;

    @Override
    public List seind() {
        List lis=solidao.seind();
        return lis;
    }

    @Override
    public List seall() {
        List lis=solidao.seall();
        return lis;
    }

    @Override
    public SongList getSongList(int solid) {
        return solidao.getSongList(solid);
    }

    @Override
    public PageInfo solall(int p) {
        //分页  当前1页  每页10条
        PageHelper.startPage(p,10);
        List list = solidao.seall();
        PageInfo page = new PageInfo(list,7);
        return page;
    }

    @Override
    public PageInfo solall(int sotid, int p) {
        //分页  当前1页  每页10条
        PageHelper.startPage(p,10);
        List list = solidao.solall(sotid);
        PageInfo page = new PageInfo(list,7);
        return page;
    }

    /**
     * 查询总数
     * @return
     */
    @Override
    public int solicount() {
        int coun=solidao.solicount();
        return coun;
    }

    @Override
    public List vipall() {
        //所有歌单
        List list = solidao.seall();
        List viplist = new ArrayList();
        for(int i=0;i<list.size();i++){
            boolean is = true;
            SongList sol = (SongList)list.get(i);
            String[] strAry = sol.getSoid().split(",");
//            System.out.println(Arrays.toString(strAry));
            List son = songDao.getSongAll(strAry);
            if(son.size()==0){
                is = false;
            }else{
                for(int j=0;j<son.size();j++){
                    Song so = (Song)son.get(j);
                    if(so.getSovip()==0){
                        is = false;
                    }
                }
            }
            if(is){
                viplist.add(sol);
            }
        }

        return viplist;
    }
}
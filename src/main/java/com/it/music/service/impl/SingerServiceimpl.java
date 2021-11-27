package com.it.music.service.impl;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.dao.SingerDao;
import com.it.music.entity.Singer;
import com.it.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 羡羡
 */
@Service
public class SingerServiceimpl implements SingerService {

    @Autowired
    SingerDao sing;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List seall() {
        List lis=sing.seall();
        return lis;
    }

    /**
     * 歌手添加
     * @param sin
     * @return
     */
    @Override
    public int singadd(Singer sin) {
        int sinad=sing.singadd(sin);
        return sinad;
    }

    /**
     * 查询首页
     * @return
     */
    @Override
    public List seindx() {
        List ls=sing.seindx();
        return ls;
    }

    @Override
    public Singer getSinger(int siid) {
        return sing.getSinger(siid);
    }

    /**
     * 更多歌手
     * @param firstle 歌手首字母
     * @param dq 歌手地区
     * @param lb 歌手类型
     * @return
     */
    @Override
    public List morsinger(String firstle,int dq,int lb) {
        System.out.println("firstle:"+firstle+" "+"dq:"+dq+" "+"lb:"+lb);
        List<Singer> lis =new ArrayList<>();
        //查询所有
        if("all".equals(firstle) && dq==0 && lb==0){
            //查询所有
            lis=sing.seall();
            //查询只选择了字母
        }else if(!"all".equals(firstle) && dq==0 && lb==0){
            List seua=sing.seallsing();
            //循环遍历
            for(int i=0;i<seua.size();i++){
                Singer sinen= (Singer) seua.get(i);
                System.out.println(sinen);
                //得到歌手name
                String sn=sinen.getSiname();
                //截取姓
                String sname=sn.substring(0,1);
                System.out.println("sname:"+sname);
                //得到姓然后转换成生成拼音得到首字母
                String result = PinyinUtil.getFirstLetter(sname,",");
                //转换成大写
                String firstLetter=result.toUpperCase();
                System.out.println(firstLetter);
                if(firstLetter.equals(firstle)){
                    Singer si=new Singer(sinen.getSiid(),sinen.getSiname(),sinen.getSiintro(), sinen.getSiimg(),sinen.getSiarea(),sinen.getSitype());
                    lis.add(si);
                }
            }
            //只查询地区
        }else if("all".equals(firstle) && dq!=0 && lb==0){
            lis=sing.sedq(dq);
            //只查询类别
        }else if("all".equals(firstle) && dq==0 && lb!=0){
            lis=sing.sety(lb);
        }else if(!"all".equals(firstle) && dq!=0 && lb==0){
            List sea=sing.seall();
            //循环遍历
            for(int i=0;i<sea.size();i++){
                Singer sinen= (Singer) sea.get(i);
                //得到歌手name
                String sn=sinen.getSiname();
                //截取姓
                String sname=sn.substring(0,1);
                //得到姓然后转换成生成拼音得到首字母
                String result = PinyinUtil.getFirstLetter(sname,",");
                //转换成大写
                String firstLetter=result.toUpperCase();
                if(firstle.equals(firstLetter) && sinen.getSiarea()==dq){
                    Singer si=new Singer(sinen.getSiid(),sinen.getSiname(),sinen.getSiintro(), sinen.getSiimg(),sinen.getSiarea(),sinen.getSitype());
                    System.out.println(si);
                    lis.add(si);
                }
            }
        }else if(!"all".equals(firstle) && dq==0 && lb!=0){
            List sea=sing.seall();
            //循环遍历
            for(int i=0;i<sea.size();i++){
                Singer sinen= (Singer) sea.get(i);
                //得到歌手name
                String sn=sinen.getSiname();
                //截取姓
                String sname=sn.substring(0,1);
                //得到姓然后转换成生成拼音得到首字母
                String result = PinyinUtil.getFirstLetter(sname,",");
                //转换成大写
                String firstLetter=result.toUpperCase();
                if(firstle.equals(firstLetter) && sinen.getSitype()==lb){
                    Singer si=new Singer(sinen.getSiid(),sinen.getSiname(),sinen.getSiintro(), sinen.getSiimg(),sinen.getSiarea(),sinen.getSitype());
                    lis.add(si);
                }
            }
        }else if("all".equals(firstle) && dq!=0 && lb!=0){
            Singer sin=new Singer();
            sin.setSiarea(dq);
            sin.setSitype(lb);
            lis=sing.sedqty(sin);
        }else if(!"all".equals(firstle) && dq!=0 && lb!=0){
            List sea=sing.seall();
            //循环遍历
            for(int i=0;i<sea.size();i++){
                Singer sinen= (Singer) sea.get(i);
                //得到歌手name
                String sn=sinen.getSiname();
                //截取姓
                String sname=sn.substring(0,1);
                //得到姓然后转换成生成拼音得到首字母
                String result = PinyinUtil.getFirstLetter(sname,",");
                //转换成大写
                String firstLetter=result.toUpperCase();
                if(firstle.equals(firstLetter) && sinen.getSitype()==lb && sinen.getSiarea()==dq){
                    Singer si=new Singer(sinen.getSiid(),sinen.getSiname(),sinen.getSiintro(), sinen.getSiimg(),sinen.getSiarea(),sinen.getSitype());
                    lis.add(si);
                }
            }
        }
        return lis;
    }

    @Override
    public List sedq(int siarea) {
      List lis= sing.sedq(siarea);
        return lis;
    }

    @Override
    public List sety(int sitype) {
        List lis=sing.sety(sitype);
        return lis;
    }

    @Override
    public List sedqty(Singer sin) {
        List lis=sing.sedqty(sin);
        return lis;
    }

    @Override
    public List seallsing() {
        List lis=sing.seallsing();
        return lis;
    }

    @Override
    public int singerupdate(Singer s) {
        int n = sing.singerupdate(s);
        return n;
    }

    @Override
    public int singerdel(int siid)
    {
        int n = sing.singerdel(siid);
        return n;
    }

    @Override
    public int update(Singer s) {
        int n = sing.update(s);
        return n;
    }
}

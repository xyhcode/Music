package com.it.music.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.config.SysExecptionHandler;
import com.it.music.entity.Feature;
import com.it.music.entity.SingerAll;
import com.it.music.service.*;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 羡羡
 */
@Controller
public class MusicController {
    @Autowired
    SongTypeService soty;

    @Autowired
    SongListService solise;

    @Autowired
    SongService songse;

    @Autowired
    SingerService sinse;

    @Autowired
    FeatureService fese;

    @GetMapping({"/", "/index", "index.html"})
    public String index(ModelMap mp){
        //显示首页的歌单类型
        List insoglis=soty.sein();
        mp.put("inso",insoglis);

        //歌单
        List solis=solise.seind();
        mp.put("songli",solis);

        //新歌
        List newsong=songse.songseing();
        mp.put("newsong",newsong);

        //热门歌手
        List hotsinger=sinse.seindx();
        mp.put("hotsin",hotsinger);

        //精选视频
        List felis=fese.seindex();
        mp.put("feli",felis);
        return "fontdesk/index";
    }

    /**
     * 更多视频
     * @param map
     * @return
     */
    @GetMapping("/morvide")
    public String morvid(ModelMap map){
        PageHelper.startPage(1,20);
        List lis=fese.sefe();
        PageInfo pa=new PageInfo(lis,10);
        map.put("pavo",pa);
        return "fontdesk/morevide";
    }

    /**
     * 视频分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping(path = "/showvide/{curr}",method = RequestMethod.GET)
    public String show(ModelMap map, @PathVariable("curr") int curr){
        if(curr==0){
            curr=1;
        }
        PageHelper.startPage(curr,20);
        List lis=fese.sefe();
        PageInfo pa=new PageInfo(lis,10);
        map.put("pavo",pa);
        return "fontdesk/morevide";
    }

    /**
     * 点击视频进入视频详情
     * @param map
     * @param vid 视频的ID
     * @return
     */
    @RequestMapping(path = "/videtail/{vid}",method = RequestMethod.GET)
    public String viconf(ModelMap map,@PathVariable("vid") int vid){
        Feature fea=fese.findidvoid(vid);
        map.put("features",fea);
        return "fontdesk/grvidetails";
    }

    /**
     * 更多歌手
     * @return
     */
    @RequestMapping(path="/morsinger/{sna}/{sia}/{sity}",method = RequestMethod.GET)
    public String mosing(ModelMap map, @PathVariable("sna") String sna, @PathVariable("sia") int sia, @PathVariable("sity") int sity){
        System.out.println("歌手字母："+sna+" "+"地区："+sia+" "+"歌手类型："+sity);
        /*List ls=sinse.seallsing();*/
        /*PageHelper.startPage(1,1);*/
       /* List lis=sinse.morsinger(ls,sna,sia,sity);*/
        List lis=sinse.morsinger(sna,sia,sity);
        /*PageInfo pa=new PageInfo(lis,10);*/
        map.put("mosin",lis);
        map.put("sna",sna);
        map.put("sia",sia);
        map.put("sity",sity);
        return "fontdesk/singer";
    }

    /**
     * 歌手详情
     * @return
     */
    @RequestMapping(path = "/singerdetails/{siid}",method = RequestMethod.GET)
    public String singdta(ModelMap map,@PathVariable("siid") int siid){
        SingerAll lis=songse.singerallsong(siid);
        map.put("singde",lis);
        return "fontdesk/singerdeta";
    }
}

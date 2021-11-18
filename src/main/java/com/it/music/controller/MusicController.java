package com.it.music.controller;

import com.it.music.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

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
}

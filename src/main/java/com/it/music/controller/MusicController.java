package com.it.music.controller;

import com.it.music.service.SongService;
import com.it.music.service.SongTypeService;
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

    @GetMapping({"/", "/index", "index.html"})
    public String index(ModelMap mp){
        //显示首页的歌单类型
        List insoglis=soty.sein();
        mp.put("inso",insoglis);
        return "fontdesk/index";
    }
}

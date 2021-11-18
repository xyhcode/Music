package com.it.music.controller;

import com.it.music.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MusicBoxController {

    @Autowired
    PlayListService playListService;

    @GetMapping("musicbox/{uid}")
    public String musicbox(@PathVariable("uid") int uid , ModelMap map){
        System.out.println("musicbox");
        List list=playListService.getSongList(uid);
        System.out.println(list);
        return "fontdesk/musicbox";
    }




}

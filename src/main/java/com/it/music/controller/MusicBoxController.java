package com.it.music.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.it.music.entity.SongSing;
import com.it.music.service.PlayListService;
import com.it.music.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Controller
public class MusicBoxController {

    int uid=1001;

    @Autowired
    PlayListService playListService;

    @GetMapping("musicbox")
    public String musicbox(ModelMap map){
        System.out.println("musicbox");
        List list=playListService.getSongList(uid);
        System.out.println(list);
        map.put("listInfo",list);
        return "fontdesk/musicbox";
    }

    @GetMapping("play/{soid}")
    public String play(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        List list=playListService.getSongList(uid);//播放列表歌曲
        System.out.println(list);
        map.put("listInfo",list);
        SongSing s=playListService.getSong(soid);
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        System.out.println(lyric);
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }




}

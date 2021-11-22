package com.it.music.controller;

import com.it.music.entity.Song;
import com.it.music.entity.SongSing;
import com.it.music.service.PlayListService;
import com.it.music.tools.FindSubscript;
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

    @GetMapping("/musicbox")
    public String musicbox(ModelMap map){
        System.out.println("musicbox");
        List list=playListService.getSongList(uid);
        System.out.println(list);
        map.put("listInfo",list);
        return "fontdesk/musicbox";
    }


    //播放
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

    //上一首
    @GetMapping("prev/{soid}")
    public String prev(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        List list=playListService.getSongList(uid);//播放列表歌曲
        int[] idlist=new int[list.size()];
        for (int i=0;i<list.size();i++){
            SongSing z=(SongSing)list.get(i);
            idlist[i]=z.soid;
        }
        int xb= FindSubscript.binarySearch(idlist,soid);
        int pxb=xb-1;
        if (pxb<0){
            pxb=idlist.length-1;
        }
        int sid=idlist[pxb];
        System.out.println(sid);
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }


    //下一首
    @GetMapping("next/{soid}")
    public String next(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        List list=playListService.getSongList(uid);//播放列表歌曲
        int[] idlist=new int[list.size()];
        for (int i=0;i<list.size();i++){
            SongSing z=(SongSing)list.get(i);
            idlist[i]=z.soid;
        }
        int xb= FindSubscript.binarySearch(idlist,soid);
        int pxb=xb+1;
        if (pxb>=idlist.length){
            pxb=0;
        }
        int sid=idlist[pxb];
        System.out.println(sid);
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }


}

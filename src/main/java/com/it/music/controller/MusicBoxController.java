package com.it.music.controller;

import com.it.music.entity.Song;
import com.it.music.entity.SongSing;
import com.it.music.entity.User;
import com.it.music.service.PlayListService;
import com.it.music.tools.FindSubscript;
import com.it.music.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicBoxController {
    int uid=0;
    int vip=0;

    public int getUid(){
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        User us=(User)request.getSession().getAttribute("user");
        if (us==null){
            return 0;
        }
        return us.usid;
    }

    public int getVip(){
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        User us=(User)request.getSession().getAttribute("user");
        if (us==null){
            return 0;
        }
        return us.isvip;
    }

    @Autowired
    PlayListService playListService;

    @GetMapping("/musicbox")
    public String musicbox(ModelMap map){
        uid=getUid();
        if (uid!=0){
            List list=playListService.getSongList(uid);
            map.put("listInfo",list);
        }else{
            List list=playListService.getSongs();
            map.put("listInfo",list);
        }
        return "fontdesk/musicbox";
    }


    //播放
    @GetMapping("play/{soid}")
    public String play(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        uid=getUid();
        List list;
        if (uid!=0){
            list=playListService.getSongList(uid);
            map.put("listInfo",list);
        }else{
            list=playListService.getSongs();
            map.put("listInfo",list);
        }
        SongSing s=playListService.getSong(soid);
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }

    //上一首
    @GetMapping("prev/{soid}")
    public String prev(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        vip=getVip();
        uid=getUid();
        List list;
        if (uid!=0){
            list=playListService.getSongList(uid);
            map.put("listInfo",list);
        }else{
            list=playListService.getSongs();
            map.put("listInfo",list);
        }
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
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);
        while (s.sovip==1 && vip==0){
            pxb-=1;
            if (pxb<0){
                pxb=idlist.length-1;
            }
            sid=idlist[pxb];
            s=playListService.getSong(sid);
        }
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }


    //下一首
    @GetMapping("next/{soid}")
    public String next(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        vip=getVip();
        uid=getUid();
        List list;
        if (uid!=0){
            list=playListService.getSongList(uid);
            map.put("listInfo",list);
        }else{
            list=playListService.getSongs();
            map.put("listInfo",list);
        }
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
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);
        while (s.sovip==1 && vip==0){
            pxb+=1;
            if (pxb>=idlist.length){
                pxb=0;
            }
            sid=idlist[pxb];
            s=playListService.getSong(sid);
        }
        map.put("playInfo",s);//播放歌曲信息
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        return "fontdesk/musicbox";
    }


}

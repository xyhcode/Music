package com.it.music.controller;

import com.it.music.entity.SongSing;
import com.it.music.entity.User;
import com.it.music.service.*;
import com.it.music.tools.FindSubscript;
import com.it.music.tools.JsonResult;
import com.it.music.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import com.it.music.entity.*;
import com.it.music.entity.SongSing;
import com.it.music.entity.User;
import com.it.music.service.SongListService;
import com.it.music.service.SongService;
import org.springframework.web.bind.support.SessionStatus;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    public int addSongNum(int uid,int soid){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dtime=sdf.format(date);
        int n=songNumService.add(new SongNum(uid,soid,dtime));
        return n;
    }

    @Autowired
    PlayListService playListService;

    @Autowired
    SongListService songListService;

    @Autowired
    SongNumService songNumService;

    @Autowired
    CollectService collectService;

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
        addSongNum(uid,soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",soid);
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
        System.out.println(Arrays.toString(idlist));
//        int xb= FindSubscript.binarySearch(idlist,soid);
        int xb=FindSubscript.findxb(idlist,soid);
        int pxb=xb-1;
        System.out.println("上一首："+pxb);
        if (pxb<0){
            pxb=idlist.length-1;
        }
        int sid=idlist[pxb];//上一首歌的id  255
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);//上一首歌的信息
        while (s.sovip==1 && vip==0){//上一首歌是否vip and 普通用户
            pxb-=1;//再上一首
            if (pxb<0){
                pxb=idlist.length-1;
            }
            sid=idlist[pxb];
            s=playListService.getSong(sid);
        }
        map.put("playInfo",s);//播放歌曲信息
        addSongNum(uid,s.soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",s.soid);
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
//        int xb= FindSubscript.binarySearch(idlist,soid);
        int xb=FindSubscript.findxb(idlist,soid);
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
        addSongNum(uid,s.soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",s.soid);
        return "fontdesk/musicbox";
    }

    //添加单首歌到播放表
    @GetMapping("/addplaylist/{soid}")
    public String addSong(@PathVariable("soid") int soid,ModelMap map) throws IOException {
        uid=getUid();
        vip=getVip();
        List list;
        if (uid!=0){
            UserSong us=playListService.selectSong(new UserSong(uid,soid));
            if (us==null){
                int n=playListService.addSong(new UserSong(uid,soid));
            }
            list=playListService.getSongList(uid);
            map.put("listInfo",list);
            SongSing s=playListService.getSong(soid);
            if (s.sovip==1 && vip==0){
                map.put("playInfo",null);
            }else{
                map.put("playInfo",s);
                addSongNum(uid,s.soid);
                String lyric=JsonUtil.getjson(s.getLyrics());
                map.put("lyric",lyric);
            }
        }else{
            list=playListService.getSongs();
            map.put("listInfo",list);
            SongSing s=playListService.getSong(soid);
            map.put("playInfo",s);
            String lyric= JsonUtil.getjson(s.getLyrics());
            map.put("lyric",lyric);
        }
        return "fontdesk/musicbox";
    }


    //歌单播放全部
    @GetMapping("/songlists/{solid}")
    public String songlist(@PathVariable("solid") int solid,ModelMap map){
        int i=0;
        uid=getUid();
        vip=getVip();
        SongSing ss=null;
        SongList sol = songListService.getSongList(solid);
        String[] strAry = sol.getSoid().split(",");//得到歌单数组
        if (uid!=0){//登录了
            int n=playListService.insertSongs(uid,strAry);//将歌单歌曲添加到播放列表
            List list=playListService.getSongList(uid);//查询用户的播放列表
            map.put("listInfo",list);
            int soid=Integer.parseInt(strAry[i]);
            SongSing s=playListService.getSong(soid);//得到歌单的第一首歌的信息
            if (s.sovip==1 && vip==0){//第一首歌是vip歌曲，而且用户不是vip
                while (true){
                    i+=1;
                    if (i>=strAry.length){//歌单所有歌都是vip歌曲
                        map.put("playInfo",null);
                        break;
                    }
                    SongSing z=playListService.getSong(Integer.parseInt(strAry[i]));//得到下一首的歌曲
                    if (z!=null && z.sovip==0){//判断下一首歌是不是vip歌曲
                        s=playListService.getSong(soid);
                        map.put("playInfo",z);
                        map.put("soid",z.soid);
                        break;
                    }
                }
            }else{//允许播放
                ss=playListService.getSong(soid);
                map.put("playInfo",ss);
                map.put("soid",ss.soid);
            }


        }else{
            List list=playListService.getSongs();
            map.put("listInfo",list);
        }
        return "fontdesk/musicbox";
    }

    //歌手歌单播放全部
    @GetMapping("/singerlists/{siid}")
    public String singerlist(@PathVariable("siid") int siid,ModelMap map){
        int i=0;
        uid=getUid();
        vip=getVip();
        SongSing ss=null;
        String[] strAry = playListService.getSingerSoid(siid);
        if (uid!=0){//登录了
            int n=playListService.insertSongs(uid,strAry);
            List list=playListService.getSongList(uid);
            map.put("listInfo",list);
            int soid=Integer.parseInt(strAry[i]);
            SongSing s=playListService.getSong(soid);
            if (s.sovip==1 && vip==0){//第一首歌是vip歌曲，而且用户不是vip
                while (true){
                    i+=1;
                    if (i>=strAry.length){//歌单所有歌都是vip歌曲
                        map.put("playInfo",null);
                        break;
                    }
                    SongSing z=playListService.getSong(Integer.parseInt(strAry[i]));//得到下一首的歌曲
                    if (z!=null && z.sovip==0){//判断下一首歌是不是vip歌曲
                        s=playListService.getSong(soid);
                        map.put("playInfo",z);
                        map.put("soid",z.soid);
                        break;
                    }
                }
            }else{//允许播放
                ss=playListService.getSong(soid);
                map.put("playInfo",ss);
                map.put("soid",s.soid);
            }
        }else{
            List list=playListService.getSongs();
            map.put("listInfo",list);
        }
        return "fontdesk/musicbox";
    }


    @GetMapping("/collectList/{usid}")
    public String collectList(@PathVariable("usid") int usid,ModelMap map){
        if (usid!=0){
            String[] str=collectService.findColl(uid);
            List list=new ArrayList();
            for (int i=0;i<str.length;i++){
                SongSing s=playListService.getSong(Integer.parseInt(str[i]));
                System.out.println(s);
                list.add(s);
            }
            System.out.println(list);
            map.put("listInfo",list);
        }else{
            map.put("listInfo",null);
        }
        return "fontdesk/musicbox";
    }


    @ResponseBody
    @GetMapping("/addsong/{soid}/{isvip}")
    public JsonResult addsong(@PathVariable("soid") int soid,@PathVariable("isvip") int isvip){
        JsonResult jr=null;
        vip=getVip();
        uid=getUid();
        if (uid!=0){//登录了
            System.out.println(vip+":"+isvip);
            if (vip==0 && isvip==1){//不允许播放
                jr=new JsonResult(510,"该歌曲是VIP专享，你不是VIP！");
            }else{//允许播放
                UserSong s=playListService.selectSong(new UserSong(uid,soid));//查这首歌在收藏表是否存在
                if (s==null){//不存在就添加
                    int n=playListService.addSong(new UserSong(uid,soid));
                    if (n!=0){
                        jr=new JsonResult(200,"添加成功！");
                    }else{
                        jr=new JsonResult(500,"添加失败！");
                    }
                }else{//已存在
                    jr=new JsonResult(511,"该歌曲已存在播放表！");
                }
            }
        }else{//没登录
            if (isvip==1){//不允许播放
                jr=new JsonResult(512,"该歌曲是VIP专享，你不是VIP！(未登录)");
            }else{//允许播放
                jr=new JsonResult(200,"播放成功！(未登录)");
            }
        }
        return jr;
    }



    @ResponseBody
    @RequestMapping(path = "/songyyh",method = RequestMethod.POST)
    public JsonResult song(HttpServletRequest request){

        List list = playListService.getSongList(getUid());
        JsonResult jr = new JsonResult(200,"查询成功！",list);

        return jr;
    }

}

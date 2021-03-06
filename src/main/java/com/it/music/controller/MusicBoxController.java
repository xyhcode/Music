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


    //??????
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
        map.put("playInfo",s);//??????????????????
        addSongNum(uid,soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",soid);
        return "fontdesk/musicbox";
    }

    //?????????
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
        System.out.println("????????????"+pxb);
        if (pxb<0){
            pxb=idlist.length-1;
        }
        int sid=idlist[pxb];//???????????????id  255
        map.put("listInfo",list);
        SongSing s=playListService.getSong(sid);//?????????????????????
        while (s.sovip==1 && vip==0){//??????????????????vip and ????????????
            pxb-=1;//????????????
            if (pxb<0){
                pxb=idlist.length-1;
            }
            sid=idlist[pxb];
            s=playListService.getSong(sid);
        }
        map.put("playInfo",s);//??????????????????
        addSongNum(uid,s.soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",s.soid);
        return "fontdesk/musicbox";
    }


    //?????????
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
        map.put("playInfo",s);//??????????????????
        addSongNum(uid,s.soid);
        String lyric= JsonUtil.getjson(s.getLyrics());
        map.put("lyric",lyric);
        map.put("soid",s.soid);
        return "fontdesk/musicbox";
    }

    //???????????????????????????
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


    //??????????????????
    @GetMapping("/songlists/{solid}")
    public String songlist(@PathVariable("solid") int solid,ModelMap map){
        int i=0;
        uid=getUid();
        vip=getVip();
        SongSing ss=null;
        SongList sol = songListService.getSongList(solid);
        String[] strAry = sol.getSoid().split(",");//??????????????????
        if (uid!=0){//?????????
            int n=playListService.insertSongs(uid,strAry);//????????????????????????????????????
            List list=playListService.getSongList(uid);//???????????????????????????
            map.put("listInfo",list);
            int soid=Integer.parseInt(strAry[i]);
            SongSing s=playListService.getSong(soid);//????????????????????????????????????
            if (s.sovip==1 && vip==0){//???????????????vip???????????????????????????vip
                while (true){
                    i+=1;
                    if (i>=strAry.length){//?????????????????????vip??????
                        map.put("playInfo",null);
                        break;
                    }
                    SongSing z=playListService.getSong(Integer.parseInt(strAry[i]));//????????????????????????
                    if (z!=null && z.sovip==0){//???????????????????????????vip??????
                        s=playListService.getSong(soid);
                        map.put("playInfo",z);
                        map.put("soid",z.soid);
                        break;
                    }
                }
            }else{//????????????
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

    //????????????????????????
    @GetMapping("/singerlists/{siid}")
    public String singerlist(@PathVariable("siid") int siid,ModelMap map){
        int i=0;
        uid=getUid();
        vip=getVip();
        SongSing ss=null;
        String[] strAry = playListService.getSingerSoid(siid);
        if (uid!=0){//?????????
            int n=playListService.insertSongs(uid,strAry);
            List list=playListService.getSongList(uid);
            map.put("listInfo",list);
            int soid=Integer.parseInt(strAry[i]);
            SongSing s=playListService.getSong(soid);
            if (s.sovip==1 && vip==0){//???????????????vip???????????????????????????vip
                while (true){
                    i+=1;
                    if (i>=strAry.length){//?????????????????????vip??????
                        map.put("playInfo",null);
                        break;
                    }
                    SongSing z=playListService.getSong(Integer.parseInt(strAry[i]));//????????????????????????
                    if (z!=null && z.sovip==0){//???????????????????????????vip??????
                        s=playListService.getSong(soid);
                        map.put("playInfo",z);
                        map.put("soid",z.soid);
                        break;
                    }
                }
            }else{//????????????
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


    //??????????????????
    @GetMapping("/collectList")
    public String collectList(ModelMap map){
        int i=0;
        uid=getUid();
        vip=getVip();
        SongSing ss=null;
        String[] str=collectService.findColl(uid);//?????????????????????????????????id
        int n=playListService.insertSongs(uid,str);//??????????????????????????????????????????
        List list=playListService.getSongList(uid);//???????????????
        map.put("listInfo",list);
        int soid=Integer.parseInt(str[i]);//??????????????????????????????id
        SongSing s=playListService.getSong(soid);//????????????????????????????????????
        if (s.sovip==1 && vip==0 ){//???????????????vip
            while(true){
                i+=1;
                if (i>=str.length){//?????????????????????vip??????
                    map.put("playInfo",null);
                    break;
                }
                SongSing z=playListService.getSong(Integer.parseInt(str[i]));//???????????????????????????
                if (z!=null && z.sovip==0){//??????????????????vip
                    map.put("playInfo",z);
                    map.put("soid",z.soid);
                    break;
                }
            }
        }else{//??????????????????vip
            map.put("playInfo",s);
            map.put("soid",s.soid);
        }
        return "fontdesk/musicbox";
    }


    @ResponseBody
    @GetMapping("/addsong/{soid}/{isvip}")
    public JsonResult addsong(@PathVariable("soid") int soid,@PathVariable("isvip") int isvip){
        JsonResult jr=null;
        vip=getVip();
        uid=getUid();
        if (uid!=0){//?????????
            System.out.println(vip+":"+isvip);
            if (vip==0 && isvip==1){//???????????????
                jr=new JsonResult(510,"????????????VIP??????????????????VIP???");
            }else{//????????????
                UserSong s=playListService.selectSong(new UserSong(uid,soid));//????????????????????????????????????
                if (s==null){//??????????????????
                    int n=playListService.addSong(new UserSong(uid,soid));
                    if (n!=0){
                        jr=new JsonResult(200,"???????????????");
                    }else{
                        jr=new JsonResult(500,"???????????????");
                    }
                }else{//?????????
                    jr=new JsonResult(511,"??????????????????????????????");
                }
            }
        }else{//?????????
            if (isvip==1){//???????????????
                jr=new JsonResult(512,"????????????VIP??????????????????VIP???(?????????)");
            }else{//????????????
                jr=new JsonResult(200,"???????????????(?????????)");
            }
        }
        return jr;
    }



    @ResponseBody
    @RequestMapping(path = "/songyyh",method = RequestMethod.POST)
    public JsonResult song(HttpServletRequest request){

        List list = playListService.getSongList(getUid());
        JsonResult jr = new JsonResult(200,"???????????????",list);

        return jr;
    }


    @ResponseBody
    @RequestMapping("/bflist")
    public JsonResult bflist(ModelMap map){//ajax????????????
        JsonResult jr=null;
        int uid=getUid();//????????????id
        if (uid!=0){//?????????
            List list=playListService.getSongList(uid);//??????????????????
            jr=new JsonResult(200,"???????????????",list);
        }else{//?????????
            List list=playListService.getSongs();//????????????
            jr=new JsonResult(500,"????????????",list);
        }
        return jr;
    }

    @ResponseBody
    @RequestMapping("/sclist")
    public JsonResult sclist(ModelMap map){//ajax????????????
        JsonResult jr=null;
        int uid=getUid();
        List list=playListService.getCollectList(uid);
        System.out.println(list);
        jr=new JsonResult(200,"???????????????",list);
        return jr;
    }

    @ResponseBody
    @RequestMapping("/dSong/{soid}")
    public JsonResult delSong(@PathVariable("soid") int soid,ModelMap map){//ajax????????????
        JsonResult jr=null;
        int uid=getUid();
        if (uid!=0 && soid!=0){
            int n=playListService.delSong(new UserSong(uid,soid));
            jr=new JsonResult(200,"?????????????????????",n);
        }else{
            jr=new JsonResult(500,"???????????????");
        }
        return jr;
    }

    @ResponseBody
    @RequestMapping("/dAllSong")
    public JsonResult delAllSong(ModelMap map){//ajax????????????
        JsonResult jr=null;
        int uid=getUid();
        if (uid!=0){
            int n=playListService.delAllSong(uid);
            jr=new JsonResult(200,"?????????????????????",n);
        }else{
            jr=new JsonResult(500,"???????????????");
        }
        return jr;
    }

}

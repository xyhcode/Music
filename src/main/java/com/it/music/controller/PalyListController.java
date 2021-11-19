package com.it.music.controller;

import com.it.music.entity.SongType;
import com.it.music.service.SongListService;
import com.it.music.service.SongTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lingjing
 */
@Controller
public class PalyListController {

    @Autowired
    SongTypeService songTypeService;

    @Autowired
    SongListService songListService;


    @GetMapping({"/palylist.html"})
    public String index(ModelMap mm,@RequestParam(defaultValue = "1") int p,@RequestParam(defaultValue = "0")int sotid){

        //显示歌单类型
        mm.put("type",songTypeService.setype());
        //显示歌单
//        System.out.println(p+"------:"+sotid);
        SongType sot = songTypeService.getSongType(sotid);
        if(sot==null){
            mm.put("songlistname","全部歌单");
            mm.put("songlisturl","/palylist.html?p=");
            mm.put("songlist",songListService.solall(p));
        }else{
            mm.put("songlistname",sot.sotname);
            mm.put("songlisturl","/palylist.html?sotid="+sotid+"&p=");
            mm.put("songlist",songListService.solall(sotid,p));
        }

        return "fontdesk/palylist";
    }


}

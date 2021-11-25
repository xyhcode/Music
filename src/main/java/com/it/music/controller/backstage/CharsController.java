package com.it.music.controller.backstage;

import com.it.music.service.FeatureService;
import com.it.music.service.SongListService;
import com.it.music.service.SongService;
import com.it.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/20:11
 */
@Controller
public class CharsController {

    @Autowired
    SongService sose;

    @Autowired
    SongListService solise;

    @Autowired
    FeatureService fese;

    @Autowired
    UserService use;

    @RequestMapping("/charts")
    public String echar(){
        //歌曲总数
        int socount=sose.secount();
        //歌曲总数
        int soli=solise.solicount();
        //视频总数
        int fecount=fese.fecount();
        //用户总数
        int uscount=use.uscou();
        return "backstage/chars";
    }
}

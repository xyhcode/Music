package com.it.music.controller.backstage;

import com.it.music.service.*;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @Autowired
    SongNumService sonum;

    @Autowired
    PayLogService palog;

    @RequestMapping("/charts")
    public String echar(ModelMap map){
        //歌曲总数
        int socount=sose.secount();
        //歌单总数
        int soli=solise.solicount();
        //视频总数
        int fecount=fese.fecount();
        //用户总数
        int uscount=use.uscou();
        map.put("socount",socount);
        map.put("soli",soli);
        map.put("fecount",fecount);
        map.put("uscount",uscount);
        return "backstage/chars";
    }


    /**
     * 返回播放图表数据
     * @return
     */
    @RequestMapping("/charsnumber")
    @ResponseBody
    public JsonResult chaarr(){
        //得到播放图表的数据
        List lis=sonum.sedat();
        JsonResult js=new JsonResult(200,"成功！",lis);
        return js;
    }

    /**
     * 返回会员当日收益
     * @return
     */
    @RequestMapping("/charpaynum")
    @ResponseBody
    public JsonResult chapa(){
        //得到会员收益图表数据
        List lis=palog.pacount();
        JsonResult js=new JsonResult(200,"成功！",lis);
        return js;
    }
}

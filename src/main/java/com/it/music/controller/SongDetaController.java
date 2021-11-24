package com.it.music.controller;

import com.it.music.entity.SongList;
import com.it.music.entity.SongType;
import com.it.music.service.SingerService;
import com.it.music.service.SongListService;
import com.it.music.service.SongService;
import com.it.music.service.SongTypeService;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lingjing
 */
@Controller
public class SongDetaController {

    @Autowired
    SongListService songListService;

    @Autowired
    SongTypeService songTypeService;

    @Autowired
    SongService songService;

    @Autowired
    SingerService singerService;

    @RequestMapping(path = "/songdeta/{solid}",method = RequestMethod.GET)
    public String songdeta(ModelMap mm,@PathVariable int solid){

        SongList sol = songListService.getSongList(solid);
        SongType sot = songTypeService.getSongType(sol.getSotid());
//        System.out.println("dd:"+sol.getSoid());
        String[] strAry = sol.getSoid().split(",");
        List so = songService.getSongAll(strAry);
        List gs = singerService.seall();

        mm.put("sol",sol);
        mm.put("sot",sot);
        mm.put("so",so);
        mm.put("gs",gs);

        return "fontdesk/songdeta";
    }

    @ResponseBody
    @RequestMapping(path = "/songlist/{solid}",method = RequestMethod.POST)
    public JsonResult song(@PathVariable int solid){

        SongList sol = songListService.getSongList(solid);
        String[] strAry = sol.getSoid().split(",");
        List so = songService.getSongAll(strAry);

        JsonResult jr = new JsonResult(200,"查询成功！",so);

        return jr;
    }

}

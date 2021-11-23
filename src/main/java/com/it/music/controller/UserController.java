package com.it.music.controller;

import com.it.music.entity.Collect;
import com.it.music.entity.User;
import com.it.music.service.*;
import com.it.music.tools.CosFileupload;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author lingjing
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CollectService collectService;

    @Autowired
    SongListService songListService;

    @Autowired
    SongService songService;

    @Autowired
    SingerService singerService;

    @Autowired
    FeatureService featureService;

    @RequestMapping("")
    public String user(HttpServletRequest request,ModelMap mm,@RequestParam(defaultValue = "1") int type){
        User us = (User) request.getSession().getAttribute("user");

        int count1 = collectService.showxx(us.getUsid(),1).size();
        int count2 = collectService.showxx(us.getUsid(),2).size();
        int count3 = collectService.showxx(us.getUsid(),3).size();
        mm.put("count1",count1);
        mm.put("count2",count2);
        mm.put("count3",count3);
        mm.put("type",type);

        List ls = collectService.showxx(us.getUsid(),type);
        List list= new ArrayList();

        List gs = singerService.seall();
        mm.put("gs",gs);

        switch(type){
            //歌曲
            case 1:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    list.add(songService.getSong(col.getAllid()));
                }
                mm.put("show1",list);
            }break;
            //歌单
            case 2:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    list.add(songListService.getSongList(col.getAllid()));
                }
                mm.put("show2",list);
            }break;
            //视频
            case 3:{
                for(int i=0;i<ls.size();i++){
                    Collect col = (Collect) ls.get(i);
                    list.add(featureService.findidvoid(col.getAllid()));
                }
                mm.put("show3",list);
            }break;
            default: System.out.println("type:"+type);
        }

        return "fontdesk/user";
    }


    @RequestMapping("/edit")
    public String edit(){

        return "fontdesk/edit";
    }

    /**上传头像*/
    @ResponseBody
    @RequestMapping(path = "/uptx",method = RequestMethod.POST)
    public JsonResult Singeradd(MultipartFile[] multipart, HttpServletRequest request) throws IOException {
        String img="";
        JsonResult jr = null;
        ModelAndView mv=new ModelAndView();
        User us = (User) request.getSession().getAttribute("user");
        for(MultipartFile file : multipart){
            //文件name
            String fname=file.getOriginalFilename();
            //得到时间戳
            Long time=System.currentTimeMillis();
            //找到.
            int wz=fname.lastIndexOf(".");
            //后缀名
            String filna=fname.substring(wz+1);
//            System.out.println("后缀名："+filna);
            //图片名字设置时间戳
            String pna=time+"."+filna;
//            System.out.println("图片名："+pna);
            CosFileupload.upfile(file.getInputStream(),"music/img/"+pna);
            img="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/"+pna;

        }

        User user = new User();
        user.setUsid(us.getUsid());
        user.setUsimg(img);
        int siad=userService.alter(user);
        if(siad>0){
            jr = new JsonResult(200,"上传成功！");
        }else{
            System.out.println("歌手数据库存入错误！");
            jr = new JsonResult(500,"上传失败！");
        }

        //默认头像
        String mrimg = "https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/1637562836264.jpg";
        //原来的头像
        String usimg = us.getUsimg();
        //判断是否是默认头像
        if(!usimg.equals(mrimg)) {
            String del = usimg.substring(usimg.indexOf("music/img/"), usimg.length());
//            System.out.println("del:" + del);
            //删除原来的头像
            CosFileupload.delfile(del);
        }
        //更新一下session
        request.getSession().setAttribute("user",userService.seone(us.getUsid()));

        return jr;
    }

    /**修改信息*/
    @ResponseBody
    @RequestMapping(path = "/upinfo" ,method = RequestMethod.POST)
    public JsonResult upinfo(User us,HttpServletRequest request){
        User use = (User) request.getSession().getAttribute("user");

        JsonResult jr= null;
        us.setUsid(use.getUsid());
        int siad=userService.alter(us);
        if(siad>0){
            jr = new JsonResult(200,"保存成功！");
        }else{
            jr = new JsonResult(500,"保存失败！");
        }

        //更新一下session
        request.getSession().setAttribute("user",userService.seone(use.getUsid()));

        return jr;
    }


    /*收藏显示*/
    @ResponseBody
    @RequestMapping("/{type}")
    public JsonResult show(HttpServletRequest request ,@PathVariable int type){
        User us = (User) request.getSession().getAttribute("user");

        int count1 = collectService.showxx(us.getUsid(),1).size();
        int count2 = collectService.showxx(us.getUsid(),2).size();
        int count3 = collectService.showxx(us.getUsid(),3).size();
        List list = collectService.showdata(us.getUsid(),type);
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("count1",count1);
        data.put("count2",count2);
        data.put("count3",count3);
        data.put("type",type);
        data.put("collect",list);

        JsonResult jr = new JsonResult(200,"查询成功！",data);
        return jr;
    }

    /**取消收藏*/
    @ResponseBody
    @RequestMapping("/del/{id}")
    public JsonResult del(HttpServletRequest request,@PathVariable int id){
        User us = (User) request.getSession().getAttribute("user");
        Collect col = collectService.zao(us.getUsid(),id);
        int s = collectService.del(col.getCoid());
        JsonResult jr = null;
        if(s>0){
            jr = new JsonResult(200,"取消成功！");
        }else{
            jr = new JsonResult(500,"取消失败！");
        }
        return jr;
    }

}

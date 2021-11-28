package com.it.music.controller;

import com.it.music.entity.Collect;
import com.it.music.entity.CollectCount;
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
    public String user(){

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
        user.setIsvip(us.getIsvip());
        user.setAge(us.getAge());
        user.setSex(us.getSex());
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
        us.setIsvip(use.getIsvip());
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

        CollectCount cc = collectService.count(us.getUsid());
        HashMap<String,Object> data = new HashMap<String,Object>();
        data.put("count1",cc.getCount1());
        data.put("count2",cc.getCount2());
        data.put("count3",cc.getCount3());
        data.put("type",type);
        if(type==1){
            data.put("collect",collectService.show1(us.getUsid()));
        }else if(type==2){
            data.put("collect",collectService.show2(us.getUsid()));
        }else if(type==3){
            data.put("collect",collectService.show3(us.getUsid()));
        }

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

    /**是否收藏*/
    @ResponseBody
    @RequestMapping("/isadd/{allid}")
    public JsonResult isadd(HttpServletRequest request,@PathVariable int allid){
        User us = (User) request.getSession().getAttribute("user");
        Collect col = collectService.zao(us.getUsid(),allid);
        JsonResult jr = null;
        if(col!=null){
            jr = new JsonResult(202,"已添加！");
        }else{
            jr = new JsonResult(200,"添加！");
        }
        return jr;
    }

    /**收藏*/
    @ResponseBody
    @RequestMapping("/add")
    public JsonResult add(HttpServletRequest request,Collect collect){
        User us = (User) request.getSession().getAttribute("user");
        collect.setUsid(us.getUsid());

        JsonResult jr = null;
        int s = collectService.add(collect);
        if(s>0){
            jr = new JsonResult(200,"添加成功！");
        }else{
            jr = new JsonResult(500,"添加失败！");
        }
        return jr;
    }

}

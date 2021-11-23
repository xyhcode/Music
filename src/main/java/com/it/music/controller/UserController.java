package com.it.music.controller;

import com.it.music.entity.User;
import com.it.music.service.UserService;
import com.it.music.tools.CosFileupload;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lingjing
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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

}

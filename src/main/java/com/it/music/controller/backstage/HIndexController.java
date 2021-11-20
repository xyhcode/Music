package com.it.music.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lingjing
 *
 */
@Controller
public class HIndexController {

    /**首页页面*/
    @RequestMapping({"/admin","/admin/index"})
    public String index(){
        System.out.println("admin index");
        return "/backstage/index";
    }

    /**用户管理页面*/
    @RequestMapping("/admin/user")
    public String user(){
        System.out.println("admin user");
        return "/backstage/user";
    }

    /**用户添加页面*/
    @RequestMapping("/admin/adduser")
    public String adduser(){
        System.out.println("admin adduser");
        return "/backstage/adduser";
    }

    /**歌曲管理页面*/
    @RequestMapping("/admin/song")
    public String song(){
        System.out.println("admin song");
        return "/backstage/song";
    }

}

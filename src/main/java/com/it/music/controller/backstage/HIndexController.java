package com.it.music.controller.backstage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.music.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author lingjing
 *
 */
@Controller
public class HIndexController {
    @Autowired
    PayLogService pase;

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

    /**
     * 交易日志
     * @param map
     * @return
     */
    @RequestMapping("/admin/paylog")
    public String pay(ModelMap map){
        PageHelper.startPage(1,11);
        List lis=pase.sepaylog();
        PageInfo pa=new PageInfo(lis,10);
        map.put("payli",pa);
        return "backstage/paylog";
    }

    /**
     * 交易日志分页
     * @param map
     * @param curr
     * @return
     */
    @RequestMapping(path = "/paylog/{curr}",method = RequestMethod.GET)
    public String paypage(ModelMap map, @PathVariable("curr") int curr){
        PageHelper.startPage(curr,11);
        List lis=pase.sepaylog();
        PageInfo pa=new PageInfo(lis,10);
        map.put("payli",pa);
        return "backstage/paylog";
    }

}

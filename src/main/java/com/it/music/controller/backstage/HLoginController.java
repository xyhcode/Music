package com.it.music.controller.backstage;

import com.it.music.entity.Admin;
import com.it.music.service.AdminService;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lingjing
 */
@Controller
public class HLoginController {

    @Autowired
    AdminService adminService;

    @RequestMapping({"/adminlogin"})
    public String lo(){

        return "backstage/login";
    }

    @ResponseBody
    @RequestMapping({"/isadmin"})
    public JsonResult login(Admin am, HttpServletRequest request){
//        System.out.println("admin login"+am);
        Admin admin = adminService.login(am);
        JsonResult jr = null;
        if(admin != null){
            request.getSession().setAttribute("admin",admin);
            jr = new JsonResult(200,"登录成功！");
        }else{
            jr = new JsonResult(500,"登录失败！");
        }
        return jr;
    }

    @RequestMapping("/adminexit")
    public String exit(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/adminlogin";
    }
}

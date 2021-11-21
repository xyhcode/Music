package com.it.music.controller;

import com.it.music.entity.User;
import com.it.music.service.UserService;
import com.it.music.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lingjing
 */
@Controller
public class QLoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.html")
    public String loginpage(){
        return "fontdesk/login";
    }

    @ResponseBody
    @RequestMapping("/login")
    public JsonResult login(HttpServletRequest request, User us){
//        System.out.println("手机号："+us.getPhone());
//        System.out.println("密码："+us.getPassword());
        User user = userService.login(us);
        JsonResult jr = null;
        if(user != null){
            request.getSession().setAttribute("user",user);
            jr = new JsonResult(200,"登录成功！");
        }else{
            jr = new JsonResult(500,"登录失败！");
        }
        return jr;
    }

}

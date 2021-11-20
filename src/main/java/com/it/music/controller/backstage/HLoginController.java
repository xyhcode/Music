package com.it.music.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lingjing
 */
@Controller
public class HLoginController {

    @RequestMapping({"/admin/login"})
    public String login(){
        System.out.println("admin login");
        return "/backstage/login";
    }
}

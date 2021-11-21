package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lingjing
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){

        return "fontdesk/user";
    }

    @RequestMapping("/user/edit")
    public String edit(){

        return "fontdesk/edit";
    }

}

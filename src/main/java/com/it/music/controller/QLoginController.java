package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lingjing
 */
@Controller
public class QLoginController {

    @RequestMapping("/login.html")
    public String loginpage(){

        return "fontdesk/login";
    }
}

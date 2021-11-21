package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author lingjing
 */
@Controller
public class RegisteredController {

    @RequestMapping("/registered.html")
    public String registeredpage(){

        return "fontdesk/registered";
    }
}

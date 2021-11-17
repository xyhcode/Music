package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lingjing
 */
@Controller
public class VipController {

    @GetMapping({"/vip", "/vip.html"})
    public String index(){
        System.out.println("vap");
        return "fontdesk/vip";
    }
}

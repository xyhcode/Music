package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lingjing
 */
@Controller
public class SingerController {

    @GetMapping({"/singer", "/singer.html"})
    public String index(){
        System.out.println("singer");
        return "fontdesk/singer";
    }
}

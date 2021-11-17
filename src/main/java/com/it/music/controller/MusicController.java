package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 羡羡
 */
@Controller
public class MusicController {

    @GetMapping({"/", "/index", "index.html"})
    public String index(){
        System.out.println("index");
        return "fontdesk/index";
    }
}

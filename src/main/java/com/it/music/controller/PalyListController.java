package com.it.music.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lingjing
 */
@Controller
public class PalyListController {

    @GetMapping({"/palylist", "/palylist.html"})
    public String index(){
        System.out.println("palylist");
        return "fontdesk/palylist";
    }
}

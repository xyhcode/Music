package com.it.music.controller.backstage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 羡羡
 * @Date: 2021/11/24/20:11
 */
@Controller
public class CharsController {
    @RequestMapping("/test")
    public String cf(){
        return "backstage/chars";
    }

}

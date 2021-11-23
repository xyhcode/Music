package com.it.music.controller;

import com.it.music.entity.User;
import com.it.music.service.UserService;
import com.it.music.tools.JsonResult;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author lingjing
 */
@Controller
public class RegisteredController {

    @Autowired
    UserService use;

    @RequestMapping("/registered.html")
    public String registeredpage(){
        return "fontdesk/registered";
    }

    int codenumber;
    String Useriphone;

    /**
     * 发送验证码
     * @param iphone
     * @return
     */
    @RequestMapping(path = "/sendcode/{iphone}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult sendcode(@PathVariable("iphone") String iphone){
        int code=use.vercode(iphone);
        JsonResult js;
        if(code!=0){
            System.out.println("code:"+code);
            codenumber=code;
            js=new JsonResult(200,"成功！");
        }else{
            js=new JsonResult(500,"失败！");
        }
        return js;
    }

    /**
     * 验证用户手机
     * @param iphone
     * @return
     */
    @RequestMapping(path="/veryphone/{iphone}",method =RequestMethod.POST)
    @ResponseBody
    public JsonResult veriphone(@PathVariable("iphone") String iphone){
        JsonResult js;
        User us=use.seiphone(iphone);
        if(us!=null){
            js=new JsonResult(302,"成功！");
        }else{
            Useriphone=iphone;
            js=new JsonResult(200,"成功");
        }
        return js;
    }

    /**
     * 验证用户输入的验证码
     * @param code 用户输入的code
     * @return
     */
    @RequestMapping(path = "/verycode/{iphone}/{code}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult verifycode(@PathVariable("code") int code){
        JsonResult js;
        System.out.println("验证code:"+code);
        if(code==codenumber){
            js=new JsonResult(200,"成功");
        }else{
            js=new JsonResult(500,"错误！");
        }
        return js;
    }

    @RequestMapping(path="/regis/{password}",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult regis(@PathVariable("password") String password){
        JsonResult js;
        String ranname= RandomStringUtils.randomAlphanumeric(8);
        String usimg="https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/music/img/1637562836264.jpg";
        User us=new User(ranname,0,0,Useriphone,password,"",usimg,0,"");
        int rco=use.Userreg(us);
        if(rco>0){
            js=new JsonResult(200,"成功！");
        }else{
            js=new JsonResult(500,"失败！");
        }
        return js;
    }
}

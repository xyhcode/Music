package com.it.music.config;

import com.it.music.config.AjaxExecption;
import com.it.music.tools.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 羡羡
 * 系统异常处理器
 */
@ControllerAdvice
public class SysExecptionHandler extends Throwable {

    /**
     * 普通自定义异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleNormal(HttpServletRequest request, HttpServletResponse response, Exception ex){
        ModelAndView mv=new ModelAndView();
        mv.addObject("errmsg",ex.getMessage());
        mv.setViewName("error/err500");
        return mv;
    }

    /**
     * ajax异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = AjaxExecption.class)
    @ResponseBody
    public JsonResult handleAjax(HttpServletRequest request, HttpServletResponse response, Exception ex){
        JsonResult js=new JsonResult(500,ex.getMessage());
        return js;
    }
}

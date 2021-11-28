package com.it.music.interceptor;

import com.it.music.entity.Admin;
import com.it.music.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lingjing
 */
@Component
public class HLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println("0___________________________________0："+handler);
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin!=null){
            return true;
        }

        response.sendRedirect("/adminlogin");

        return false;
    }
}

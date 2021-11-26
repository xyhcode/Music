package com.it.music.interceptor;

import com.it.music.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lingjing
 */
@Component
public class QLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("0___________________________________0："+handler);
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            return true;
        }

        response.sendRedirect("/login.html");

        return false;
    }
}

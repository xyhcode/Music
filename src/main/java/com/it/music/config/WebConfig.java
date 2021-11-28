package com.it.music.config;

import com.it.music.interceptor.HLoginInterceptor;
import com.it.music.interceptor.QLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lingjing
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    QLoginInterceptor qLoginInterceptor;

    @Autowired
    HLoginInterceptor hLoginInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*前端登录拦截*/
        registry.addInterceptor(qLoginInterceptor)
                .addPathPatterns("/user/**");

        /*后端端登录拦截*/
        registry.addInterceptor(hLoginInterceptor)
                .addPathPatterns("/admin/**");
    }


}

package com.it.music.config;

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


    /*前端登录拦截*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(qLoginInterceptor)
                .addPathPatterns("/user/**");
    }

}

package com.it.music.config;

import com.it.music.interceptor.HLoginInterceptor;
import com.it.music.interceptor.QLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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

    /**增加全网跨域*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有
        registry.addMapping("/**")
                /*支持的方法*/
                .allowedOriginPatterns("*")
                //支持的方法
                .allowedMethods("GET","POST","PUT","DELETE","HEAD","OPTIONS")
                //证书
                .allowCredentials(true)
                //超时
                .maxAge(3600)
                //允许头
                .allowedHeaders("*");
    }

    /**增加拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*前端登录拦截*/
        registry.addInterceptor(qLoginInterceptor)
                .addPathPatterns("/user/**");

        /*后端端登录拦截*/
        registry.addInterceptor(hLoginInterceptor)
                .addPathPatterns("/charts")
                .addPathPatterns("/admin/**");
    }


}

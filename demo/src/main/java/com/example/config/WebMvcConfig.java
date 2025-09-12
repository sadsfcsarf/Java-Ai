package com.example.config;

import com.example.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
* 当前项目的总配置类，配置组件生效
* */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private UserMethodArgResolver userMethodArgResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(userMethodArgResolver);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //要访问的静态音频文件路径
        Path path = Paths.get("D:\\JavaProject\\JavaAI\\demo\\src\\main\\resources\\static\\audio").toAbsolutePath();
        Path pathImg = Paths.get("D:\\JavaProject\\JavaAI\\demo\\src\\main\\resources\\static\\img").toAbsolutePath();
        //url路径和静态文件映射
        registry.addResourceHandler("/audio/**")
                .addResourceLocations("file:"+path.toString()+"/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:"+pathImg.toString()+"/");

    }
    //注册过滤器生效

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login","/api/user/register");
    }



}

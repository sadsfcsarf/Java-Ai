package com.example.config;
import com.example.annotation.LoginUser;
import com.example.dto.UserDto;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component

public class UserMethodArgResolver implements HandlerMethodArgumentResolver {

    //文件赋值的参数需要满足哪些条件
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //参数类型是UserDto的，并且被@LoginUser注解修饰的
        return parameter.getParameterType().isAssignableFrom(UserDto.class)&&
                parameter.hasParameterAnnotation(LoginUser.class);
    }

    //如何给参数赋值
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //从会话中取出保存的用户信息
        Object user =webRequest.getAttribute("user", RequestAttributes.SCOPE_SESSION);
        return user;
    }
}
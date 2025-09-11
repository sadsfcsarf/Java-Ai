package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

//用于全局处理异常
@ControllerAdvice
@ResponseBody
public class AuthExceptionHandler {
    //创建全局异常处理方法，处理未登录状态的异常
    @ExceptionHandler(AuthException.class)


    public Map<String, Object> authException(AuthException e)
    {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 401);
        result.put("msg", e.getMessage());
        return result;
    }
}

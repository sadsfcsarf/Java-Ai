package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Map<String, Object> login(String usernameOrPhone, String password, HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        try {
            UserDto userDto = userService.login(usernameOrPhone, password);
            //当用户登录成功，将用户信息保存到session中
            session.setAttribute("user", userDto);

            result.put("data", userDto);
            result.put("code", 200);
        } catch (Exception e) {
            //在控制台打印异常信息
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", e.getMessage());
        }
        return result;


    }

    @RequestMapping("/register")
    public Map<String, Object> register(UserDto userDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            userService.register(userDto);
            result.put("code", 200);
        } catch (Exception e) {
            //在控制台打印异常信息
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", e.getMessage());
        }
        return result;


    }


}

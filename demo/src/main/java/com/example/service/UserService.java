package com.example.service;

import com.example.dto.UserDto;

public interface UserService {

    //用户登录
    UserDto login(String usernameOrPhone, String password);
    //用户注册
    void register(UserDto userDto);

}

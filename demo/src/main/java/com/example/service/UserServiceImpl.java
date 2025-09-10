package com.example.service;

import com.example.dto.UserDto;
import com.example.exception.MyException;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto login(String usernameOrPhone, String password) {
        // 根据用户名或手机号查询用户
        UserDto userDto = userMapper.selectUserByUserNameOrPhone(usernameOrPhone);
        //如果根据用户名可以查询到信息并且密码匹配
        if (userDto != null && userDto.getPassword().equals(password)) {
            return userDto;
        }
        //如果登录失败，提出异常信息
        throw new MyException("用户名或密码输入不正确");


    }

    @Override
    public void register(UserDto userDto) {
        //根据用户名查询
        UserDto result1 = userMapper.selectUserByUserNameOrPhone(userDto.getUsername());
        //根据手机号查询
        UserDto result2 = userMapper.selectUserByUserNameOrPhone(userDto.getPhone());
        if (result1 != null || result2 != null) {
            //如果用户名或手机号已经存在，则抛出异常
            throw new MyException("用户名或手机号已存在");
        }
        //插入注册
        userMapper.insertUser(userDto);

    }
}

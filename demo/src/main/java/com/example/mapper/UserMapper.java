package com.example.mapper;

import com.example.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    //插入方法 注册的时候使用
    void insertUser(UserDto userDto);
    //根据用户名或者手机号查询，登录的时候使用
    UserDto selectUserByUserNameOrPhone(String param);


}

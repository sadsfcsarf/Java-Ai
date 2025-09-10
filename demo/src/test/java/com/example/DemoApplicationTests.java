package com.example;

import com.example.dto.UserDto;
import com.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        String insertSql = "insert into user values(null,'admin','123456','铁蛋','男','1234567890',now())";
        //执行插入的sql语句
        jdbcTemplate.execute(insertSql);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void testUser() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test");
        userDto.setPassword("123456");
        userDto.setNickname("翠花");
        userDto.setSex("女");
        userDto.setPhone("1234567891");
        userMapper.insertUser(userDto);
    }
    @Test
    void testUserSelect() {
        //根据用户名或手机号查询用户信息，同时保证数据库中用户名或手机号是唯一的
        UserDto userDto = userMapper.selectUserByUserNameOrPhone("admin");
        System.out.println(userDto);
    }

}

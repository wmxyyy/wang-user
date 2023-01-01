package com.wang.user;

import com.wang.user.dao.UserMapper;
import com.wang.user.entity.UserEntity;
import com.wang.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("1000001");
        userEntity.setPhone("18934124828");
        userEntity.setUsername("王小明");
        userEntity.setPassword("mima");
        userEntity.setNickName("小明");
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setUpdateTime(LocalDateTime.now());
        userMapper.insert(userEntity);
    }

}

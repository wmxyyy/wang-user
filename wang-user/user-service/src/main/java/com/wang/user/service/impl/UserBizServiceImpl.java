package com.wang.user.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.wang.common.utils.Md5Util;
import com.wang.common.utils.Result;
import com.wang.user.dto.UserDTO;
import com.wang.user.service.UserBizService;
import com.wang.user.service.UserService;
import com.wang.user.vo.param.UserParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author wang
 * @version 1.0.0
 * @description TODO
 * @date 2022/12/25 05:22
 */
@Service
public class UserBizServiceImpl implements UserBizService {

    @Resource
    UserService userService;

    @Override
    public void register(UserParam userParam) {
        UserDTO existUserDTO = userService.findOne(userParam);
        if (Objects.nonNull(existUserDTO)){
            Result.error("该账号已注册");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setPhone(userParam.getPhone());
        userDTO.setUsername(userParam.getUsername());
        userDTO.setPassword(Md5Util.pswToUser(userParam.getPassword()));
        userDTO.setNickName(userParam.getNickName());
        userDTO.setCreateTime(LocalDateTime.now());
        userDTO.setUpdateTime(LocalDateTime.now());
        userService.saveDto(userDTO);
    }

    @Override
    public UserDTO login(UserParam userParam) {
        UserParam userNameBuild = UserParam.builder()
                .username(userParam.getUsername())
                .build();
        UserDTO userNameDTO = userService.findOne(userNameBuild);
        if (Objects.isNull(userNameDTO)){
            Result.error("该用户不存在");
        }
        UserParam userParamBuild = UserParam.builder()
                .username(userParam.getUsername())
                .password(Md5Util.pswToUser(userParam.getPassword()))
                .build();
        UserDTO userDTO = userService.findOne(userParamBuild);
        if (Objects.isNull(userDTO)){
            Result.error("密码错误");
        }
        return userDTO;
    }

}

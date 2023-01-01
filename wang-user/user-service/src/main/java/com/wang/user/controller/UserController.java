package com.wang.user.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.wang.common.utils.ConvertUtil;
import com.wang.common.utils.Result;
import com.wang.user.dto.UserDTO;
import com.wang.user.service.UserBizService;
import com.wang.user.vo.param.UserParam;
import com.wang.user.vo.response.UserResponse;
import com.wang.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wang
 * @version 1.0.0
 * @description
 * @date 2022/12/24 03:48
 */
@RestController
@RequestMapping("/wang-user/user")
@Api(tags = "用户信息")
public class UserController {

    @Resource
    UserService userService;

    @Resource
    UserBizService userBizService;
    
    @PostMapping("/list")
    @ApiOperation("用户信息列表查询")
    public Result<List<UserResponse>> selectList(UserParam userParam){
        List<UserDTO> userDTOList = userService.list(userParam);
        List<UserResponse> userResponses = ConvertUtil.sourceToTarget(userDTOList, UserResponse.class);
        return Result.succeed(userResponses);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<Void> register(@RequestBody UserParam userParam){
        userBizService.register(userParam);
        return Result.succeed();
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserDTO> login(@RequestBody UserParam userParam){
        UserDTO userDTO = userBizService.login(userParam);
        return Result.succeed(userDTO);
    }

}

package com.wang.user.service;

import com.wang.user.dto.UserDTO;
import com.wang.user.vo.param.UserParam;

/**
 * @author wang
 * @version 1.0.0
 * @description TODO
 * @date 2022/12/25 05:12
 */
public interface UserBizService {

    /**
     * 注册
     */
    void register(UserParam userParam);

    /**
     * 登录
     */
    UserDTO login(UserParam userParam);

}

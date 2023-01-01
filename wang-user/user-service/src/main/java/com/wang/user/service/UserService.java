package com.wang.user.service;


import com.wang.common.dal.CurdService;
import com.wang.user.dto.UserDTO;
import com.wang.user.entity.UserEntity;
import com.wang.user.vo.param.UserParam;

/**
 * @author wang
 * @version 1.0.0
 * @description
 * @date 2022/12/24 03:48
 */
public interface UserService extends CurdService<UserEntity, UserDTO, UserParam> {

}

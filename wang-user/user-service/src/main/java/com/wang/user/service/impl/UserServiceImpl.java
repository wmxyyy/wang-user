package com.wang.user.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.common.dal.impl.CurdServiceImpl;
import com.wang.user.dao.UserMapper;
import com.wang.user.dto.UserDTO;
import com.wang.user.entity.UserEntity;
import com.wang.user.service.UserService;

import com.wang.user.vo.param.UserParam;
import org.springframework.stereotype.Service;

/**
 * @author wang
 * @version 1.0.0
 * @description
 * @date 2022/12/24 03:48
 */
@Service
public class UserServiceImpl extends CurdServiceImpl<UserMapper, UserEntity, UserDTO, UserParam> implements UserService {


    @Override
    public QueryWrapper<UserEntity> getWrapper(UserParam queryParam) {
        return new QueryWrapper<UserEntity>();
    }
}

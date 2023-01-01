package com.wang.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wang.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wang
 * @version 1.0.0
 * @description
 * @date 2022/12/24 03:48
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {


}

package com.wang.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wang
 * @version 1.0.0
 * @description
 * @date 2022/12/24 03:48
 */
@Data
@TableName("wang_user")
public class UserEntity implements Serializable {

    public static final String ID = "id";
    public static final String USERID = "user_id";
    public static final String PHONE = "phone";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String NICK_NAME = "nick_name";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_TIME = "update_time";


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

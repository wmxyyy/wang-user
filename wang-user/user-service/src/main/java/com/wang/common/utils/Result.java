package com.wang.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.StringJoiner;

import static com.wang.common.constant.enums.ResultCodeEnum.FAIL;
import static com.wang.common.constant.enums.ResultCodeEnum.OK;

/**
 * @author wang
 * @version 1.0.0
 * @description 标准响应数据结构
 * @date 2022/12/25 05:27
 */
@Data
@ApiModel(description = "统一的接口响应,标准的响应数据结构")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编码：0、请求成功；500、请求成功但服务异常；403、未登录或者token已失效；401、已登录没有权限。")
    protected Integer code;

    @ApiModelProperty(value = "异常编码：10000、请求参数异常；10001、数据库操作异常；10002、接口请求超时；10003、重复/频繁请求。其他由业务方定义，当未定义时，默认400")
    protected Integer errCode;

    @ApiModelProperty(value = "消息内容")
    protected String msg;

    @ApiModelProperty(value = "响应数据")
    protected T data;

    public Result(Integer code, Integer errCode, String msg) {
        this.code = code;
        this.errCode = errCode;
        this.msg = msg;
    }

    public Result(Integer code, Integer errCode, String msg, T data) {
        this.code = code;
        this.errCode = errCode;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> succeed() {
        return new Result<>(OK.getCode(), OK.getCode(), OK.getDesc(), null);
    }

    public static <T> Result<T> succeed(T data) {
        return new Result<>(OK.getCode(), OK.getCode(), OK.getDesc(), data);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(FAIL.getCode(), FAIL.getCode(), msg);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("errCode=" + errCode)
                .add("msg='" + msg + "'")
                .add("data=" + data)
                .toString();
    }
}

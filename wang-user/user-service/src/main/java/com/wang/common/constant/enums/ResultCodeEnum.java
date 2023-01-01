package com.wang.common.constant.enums;

import lombok.Getter;

/**
 * @author wang
 * @version 1.0.0
 * @description 响应错误编码
 * @date 2022/12/25 05:33
 */
public enum ResultCodeEnum {

    /**
     * 请求/操作成功
     */
    OK(0, "请求/操作成功"),

    /**
     * 请求成功但是服务异常
     */
    FAIL(500, "请求成功但是服务异常"),

    /**
     * 未登录或token已经失效
     */
    UNAUTHORIZED(401, "未登录或token已经失效"),

    /**
     * 没有权限
     */
    FORBIDDEN(403, "没有权限");

    /**
     * 响应码
     */
    @Getter
    private Integer code;

    /**
     * 响应码中文描述
     */
    @Getter
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(Integer code) {
        String desc = "";
        for (ResultCodeEnum codeEnum : ResultCodeEnum.values()) {
            if (codeEnum.getCode().equals(code)) {
                desc = codeEnum.getDesc();
                break;
            }
        }
        return desc;
    }

    public static ResultCodeEnum getByCode(Integer code) {
        ResultCodeEnum resultCodeEnum = null;
        for (ResultCodeEnum codeEnum : ResultCodeEnum.values()) {
            if (codeEnum.getCode().equals(code)) {
                resultCodeEnum = codeEnum;
                break;
            }
        }
        return resultCodeEnum;
    }
}

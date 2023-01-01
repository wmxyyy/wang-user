package com.wang.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wang.user.dto.UserDTO;

import java.util.Calendar;

/**
 * @author wang
 * @version 1.0.0
 * @description TODO
 * @date 2022/12/25 06:56
 */
public class JwtUtil {

    //设置token过期时间
    public static final long EXPIRE = 1000 * 60 * 60 * 24;    //一天


    /**
     * 生成token
     * @param userDTO
     * @return
     */
    public String generateToken(UserDTO userDTO) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        JWTCreator.Builder token = JWT.create();
        return token.withClaim(userDTO.getUsername(), userDTO.getUsername()).sign(Algorithm.HMAC256(userDTO.getPassword()));
    }

    /**
     * 判断token是否存在与有效
     * @param userDTO
     * @param token
     * @return
     */
    public static DecodedJWT checkToken(UserDTO userDTO, String token) {

        JWTVerifier build = JWT.require(Algorithm.HMAC256(userDTO.getPassword())).build();
        return build.verify(token);

    }

    public static void main(String[] args) {
        JwtUtil jwtUtils = new JwtUtil();
        String aaa = jwtUtils.generateToken(UserDTO.builder().username("aaa").password("vvv").build());
        System.out.println(aaa);
        DecodedJWT decodedJWT = checkToken(UserDTO.builder().username("aaa").password("vvv").build(), aaa);
        System.out.println(decodedJWT);
    }
}

package com.example.springboot.common.constant;

/**
 * @author wfm
 * @title: SecurityConstant
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/129:02
 */
public interface SecurityConstant {
    /**
     * token分割
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * JWT签名加密key
     */
    String JWT_SIGN_KEY = "newgrand_gsoft";

    /**
     * token参数头
     */
    String HEADER = "Authorization";

    /**
     * 权限参数头
     */
    String AUTHORITY = "authority";

    /**
     * 交互token前缀key
     */
    String TOKEN_PRE = "XBOOT_TOKEN_PRE:";

    /**
     * 用户token前缀key 单点登录使用
     */
    String USER_TOKEN = "XBOOT_USER_TOKEN:";
}

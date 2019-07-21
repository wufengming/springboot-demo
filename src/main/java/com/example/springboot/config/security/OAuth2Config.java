//package com.example.springboot.config.security;
//
//import com.example.springboot.common.constant.SecurityConstant;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
//
///**
// * @author wfm
// * @title: OAuth2Config
// * @projectName springboot3
// * @description: 授权服务器配置
// * @date 2019/7/1820:16
// */
//@Configuration
//@EnableAuthorizationServer // 开启授权服务功能
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//    @Autowired
//    //@Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    UserDetailsService userDetailsService;
//
//
//    /**
//     * 配置客户端详情服务
//     * 客户端详细信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("user-service")// 创建一个客户端 名字是user-service
//                .secret("123456")
//                .scopes("service")
//                .authorizedGrantTypes("refresh_token", "password")
//                .accessTokenValiditySeconds(3600);
//    }
//
//
//    /**
//     * 配置jwttokenStore
//     * @param endpoints
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(jwtTokenStore())
//                .tokenEnhancer(jwtAccessTokenConverter())
//                .authenticationManager(authenticationManager);
//    }
//
//    /**
//     * JWTtokenStore
//     * @return
//     */
//    public TokenStore jwtTokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    /**
//     * 生成JTW token
//     * @return
//     */
//    private JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey(SecurityConstant.JWT_SIGN_KEY);
//        return converter;
//    }
//}

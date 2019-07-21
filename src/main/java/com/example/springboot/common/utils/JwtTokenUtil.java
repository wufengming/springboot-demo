package com.example.springboot.common.utils;

import com.example.springboot.common.constant.SecurityConstant;
import com.example.springboot.config.security.SecurityUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author wfm
 * @title: JwtTokenUtil
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1118:07
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 过期时间默认是60分钟，
     */
    @Value("${newgrand.tokenExpireTime}")
    private Integer tokenExpireTime;

    private Clock clock = DefaultClock.INSTANCE;

    /**
     * 创建token
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userDetails.getUsername());
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
                .setClaims(claims)//自定义属性
                .setSubject(subject)
                .setIssuedAt(clock.now())//jwt的签发时间
                .setExpiration(new Date(Instant.now().toEpochMilli() + tokenExpireTime * 60 * 1000)) //失效时间
                .signWith(SignatureAlgorithm.HS512, SecurityConstant.JWT_SIGN_KEY)//签名算法和密钥
                .compact();//压缩
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        SecurityUserDetails user = (SecurityUserDetails) userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername())
                && !isTokenExpired(token)
        );
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SecurityConstant.JWT_SIGN_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
}

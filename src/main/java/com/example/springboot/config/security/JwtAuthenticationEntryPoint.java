package com.example.springboot.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wfm
 * @title: JwtAuthenticationEntryPoint
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1515:01
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("JwtAuthenticationEntryPoint:" + authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "没有凭证");
    }
}

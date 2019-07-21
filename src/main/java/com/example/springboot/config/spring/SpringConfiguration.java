package com.example.springboot.config.spring;

import org.springframework.context.annotation.Configuration;

/**
 * @author wfm
 * @title: SpringConfiguration
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/511:08
 */
@Configuration
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("SpringConfiguration容器启动初始化。。。");
    }
}

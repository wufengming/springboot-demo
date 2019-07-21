package com.example.springboot.service.sys.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wfm
 * @title: AuthServiceImplTest
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1118:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.springboot.mapper.*")
public class AuthServiceImplTest {
//    @Autowired
//    private AuthService server;

    @Test
    public void login() {
        //String data= server.login("test","test");
    }
}
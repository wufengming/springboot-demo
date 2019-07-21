package com.example.springboot.service.sys.impl;


import com.example.springboot.entity.sys.User;
import com.example.springboot.service.sys.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wfm
 * @title: UserServiceImplTest
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/119:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.example.springboot.mapper.*")
public class UserServiceImplTest {
    @Autowired
    private UserService server;

    @Test
    public void selectAll() {
        List<User> data= server.selectAll();
    }

    @Test
    public void selectByCondition() {
        List<User> data=server.selectByCondition();
    }

    @Test
    public void findAll() {
        List<User> data=server.findAll();
    }

    @Test
    public void findUserById() {
        User data=server.findUserById(1L);
    }

    @Test
    public void getproductName() {

//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/";
//        String username = "root";
//        String password = "123456";
//        Class.forName(driver);
//        Connection con = (Connection) DriverManager.getConnection(url,username,password);
//        DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();
//        System.out.println("数据库的产品名称:" + metaData.getDatabaseProductName());
    }
}
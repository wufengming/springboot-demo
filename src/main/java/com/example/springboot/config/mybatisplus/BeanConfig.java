package com.example.springboot.config.mybatisplus;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author wfm
 * @title: BeanConfig
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/1615:27
 */
@Configuration
public class BeanConfig {
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        //key的值是对应的数据库的productName，value则是一个自定义的值
        Properties p = new Properties();
        p.setProperty("MySQL", "mysql");//mysql
        p.setProperty("Oracle", "oracle");//oracle
        p.setProperty("DM DBMS", "dm7");//达梦7
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }
}

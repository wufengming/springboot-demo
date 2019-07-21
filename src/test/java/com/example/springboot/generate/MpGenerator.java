package com.example.springboot.generate;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author wfm
 * @title: MpGenerator
 * @projectName springboot3
 * @description: 代码生成器
 * @date 2019/6/2713:04
 */
public class MpGenerator {

    public static void main(String[] args) throws InterruptedException {

        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");

        // 0.整合配置
        AutoGenerator mpg = new AutoGenerator();

        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rb.getString("OutputDir"));
        gc.setOpen(false);
        gc.setBaseResultMap(true);  //XML ResultMap
        gc.setBaseColumnList(true);
        gc.setAuthor(rb.getString("author"));
        gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
        //gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        //gc.setEnableCache(false);// XML 二级缓存
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        //2.数据源等配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(rb.getString("url"));
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(rb.getString("userName"));
        dsc.setPassword(rb.getString("password"));
        mpg.setDataSource(dsc);

        //3.包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(rb.getString("parent"));
        //pc.setModuleName(scanner("模块名"));
        pc.setController("controller." + rb.getString("className"));
        pc.setService("service." + rb.getString("className"));
        pc.setServiceImpl("service." + rb.getString("className") + ".impl");
        pc.setEntity("entity." + rb.getString("className"));
        pc.setMapper("mapper." + rb.getString("className"));
        mpg.setPackageInfo(pc);

        //4. 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return rb.getString("OutputDirXml") + "/mapper/" + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        //5. 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(rb.getString("tableName").split(","));
        //strategy.setSuperEntityClass("com.example.springboot.common.BaseEntity");
        //strategy.setRestControllerStyle(true);
        //strategy.setSuperControllerClass("com.example.springboot.common.BaseController");
        //strategy.setSuperEntityColumns("id");
        //strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(rb.getString("tablePrefix").split(","));// 此处可以修改为您的表前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

    }
}

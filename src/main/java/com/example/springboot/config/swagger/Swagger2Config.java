package com.example.springboot.config.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wfm
 * @title: Swagger2Config
 * @projectName springboot3
 * @description: TODO
 * @date 2019/7/2015:56
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                // 设置basePackage会将包下的所有类的所有方法作为api
                // .apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller"))
                // 只有标记@ApiOperation才会暴露出给swagger
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API接口文档")  //标题
                .description("RESTful风格接口") //描述
                .termsOfServiceUrl("http://blog.exrick.cn")  // 服务条款网址
                .version("1.0") //版本
                .contact(new Contact("wfm", "http://www.newgrand.cn", "gsoft@newgrand.cn"))
                .build();
    }
}

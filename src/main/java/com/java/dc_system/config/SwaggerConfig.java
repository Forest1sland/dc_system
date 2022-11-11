package com.java.dc_system.config;


import com.google.common.base.Predicates;
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
 * @Author: zjt
 * @Date: 2022-11-11 23:03
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo dc_systemApiInfo() {

        return new ApiInfoBuilder()
                .title("核酸检测平台-API文档")
                .description("本文档描述了核酸检测平台接口定义")
                .version("1.0")
                .contact(new Contact("zjt", "https://gitee.com/jinyuncheng/", "1790387116@qq.com"))
                .build();
    }

    @Bean
    public Docket collectorApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("collectorApi")
                .apiInfo(dc_systemApiInfo())
                .select()
                // 扫描指定包下的接口，最为常用
                .apis(RequestHandlerSelectors.basePackage("com.java.dc_system.controller")
                        //.any() // 扫描全部的接口，默认
                        //.none() // 全部不扫描
                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口
                )
                //只显示全部路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/collector/.*")))
                .build();

    }

    @Bean
    public Docket peopleApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("peopleApi")
                .apiInfo(dc_systemApiInfo())
                .select()
                // 扫描指定包下的接口，最为常用
                .apis(RequestHandlerSelectors.basePackage("com.java.dc_system.controller"))
                //只显示全部路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/people/.*")))
                .build();
    }

    @Bean
    public Docket boxApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("boxApi")
                .apiInfo(dc_systemApiInfo())
                .select()
                // 扫描指定包下的接口，最为常用
                .apis(RequestHandlerSelectors.basePackage("com.java.dc_system.controller"))
                //只显示全部路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/box/.*")))
                .build();
    }

    @Bean
    public Docket sampleApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sampleApi")
                .apiInfo(dc_systemApiInfo())
                .select()
                // 扫描指定包下的接口，最为常用
                .apis(RequestHandlerSelectors.basePackage("com.java.dc_system.controller"))
                //只显示全部路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/sample/.*")))
                .build();
    }

    @Bean
    public Docket testTubeApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("testTubeApi")
                .apiInfo(dc_systemApiInfo())
                .select()
                // 扫描指定包下的接口，最为常用
                .apis(RequestHandlerSelectors.basePackage("com.java.dc_system.controller"))
                //只显示全部路径下的页面
                .paths(Predicates.and(PathSelectors.regex("/testTube/.*")))
                .build();
    }

}


package com.java.dc_system.config;


import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zjt
 * @Date: 2022-11-11 23:03
 * @Description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

//    @Bean
//    public Docket collectorApiConfig() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("collectorApi")
//                .apiInfo(collectorApiInfo())
//                .select()
//                //只显示collector路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/collector/.*")))
//                .build();
//    }
//
//    @Bean
//    public Docket boxApiConfig() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("boxApi")
//                .apiInfo(boxApiInfo())
//                .enable(true)
//                .select()
//                //只显示box路径下的页面
//                .paths(Predicates.and(PathSelectors.regex("/box/.*")))
//                .build();
//
//    }
//
//    private ApiInfo collectorApiInfo() {
//        return new ApiInfoBuilder()
//                .title("网站-API文档")
//                .description("collector接口定义")
//                .version("1.0")
//                .contact(new Contact("zjt", "https://gitee.com/jinyuncheng/", "1790387116@qq.com"))
//                .build();
//    }
//    private ApiInfo boxApiInfo() {
//        return new ApiInfoBuilder()
//                .title("后台管理系统-API文档")
//                .description("box接口定义")
//                .version("1.0")
//                .contact(new Contact("zjt", "https://gitee.com/jinyuncheng/", "1790387116@qq.com"))
//                .build();
//    }
}


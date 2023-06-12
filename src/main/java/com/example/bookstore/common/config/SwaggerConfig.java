package com.example.bookstore.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName SwaggerConfig
 * @Description: TODO
 * @Author linjiangyi
 * @Date 9/26/22
 * @Version V1.0
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {
    @Bean
    public Docket exampleApi() {
        return new Docket(DocumentationType.SWAGGER_2) // v2 不同
                .groupName("example")
                .apiInfo(exampleApiInfo())
                .select()

                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.edu.xmut.chrimer.springboot20.example.controller"))
                //所有的controller
                //.apis(RequestHandlerSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo exampleApiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("example模块 API")
                //创建人
                //.contact(new Contact("Bryan", "http://blog.bianxh.top/", ""))
                //版本号
                // .version("1.0")
                //描述
                // .description("API 描述")
                .build();
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2) // v2 不同
                .groupName("test")
                .apiInfo(testApiInfo())
                .select()

                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("cn.edu.xmut.chrimer.springboot20.cn.edu.xmut.chrimer.springboot20.controller"))
                //所有的controller
                //.apis(RequestHandlerSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo testApiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("test模块 API")
                //创建人
                //.contact(new Contact("Bryan", "http://blog.bianxh.top/", ""))
                //版本号
                // .version("1.0")
                //描述
                // .description("API 描述")
                .build();
    }
}

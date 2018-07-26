package com.ly.xiyifu;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration

@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ly.xiyifu.rest.interfaces"))
                .paths(PathSelectors.any())
                .build()

                .securitySchemes(Lists.newArrayList(apiKey()))
                .genericModelSubstitutes(ResponseEntity.class);


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("衣物清洁APIs")
                .description("衣物清洁APIs")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("token", "Authentication", "header");
    }
}
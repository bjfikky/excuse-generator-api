package com.benorim.excusegeneratorapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ExcuseGeneratorApiApplication {

    @Value("${project.version:unknown}")
    private String version;

    @Value("${project.name:unknown}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(ExcuseGeneratorApiApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                name,
                "An API that generates random excuses.",
                version,
                null,
                new Contact("Benjamin Orimoloye", "http://www.benorim.com", null),
                null, null, Collections.emptyList());
    }
}

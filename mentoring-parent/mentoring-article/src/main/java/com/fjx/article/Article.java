package com.fjx.article;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 19:05
 * @Author: Jason
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class Article {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Article.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

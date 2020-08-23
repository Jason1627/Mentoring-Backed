package com.fjx.qa;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 18:01
 * @Author: Jason
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class Qa {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Qa.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

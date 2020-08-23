package com.fjx.spit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 19:32
 * @Author: Jason
 * @Description:
 */

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class Spit {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Spit.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

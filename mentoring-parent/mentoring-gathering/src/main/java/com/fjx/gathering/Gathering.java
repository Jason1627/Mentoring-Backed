package com.fjx.gathering;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 19:17
 * @Author: Jason
 * @Description:
 */
@EnableCaching
@SpringBootApplication
@EnableSwagger2
public class Gathering {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Gathering.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

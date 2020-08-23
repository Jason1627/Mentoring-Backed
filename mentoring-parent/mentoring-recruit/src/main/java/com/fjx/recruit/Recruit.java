package com.fjx.recruit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 17:52
 * @Author: Jason
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2
public class Recruit {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Recruit.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

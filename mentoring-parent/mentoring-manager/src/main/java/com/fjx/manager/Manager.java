package com.fjx.manager;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 20:39
 * @Author: Jason
 * @Description:
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class Manager {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Manager.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

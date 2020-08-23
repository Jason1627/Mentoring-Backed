package com.fjx.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import until.IdWorker;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 17:08
 * @Author: Jason
 * @Description:
 */
@SpringBootApplication
@EnableTransactionManagement
public class Base {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Base.class).run(args);
    }
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }
}

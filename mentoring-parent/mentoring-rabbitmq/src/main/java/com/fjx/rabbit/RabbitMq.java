package com.fjx.rabbit;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 19:24
 * @Author: Jason
 * @Description:
 */
@SpringBootApplication
public class RabbitMq {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RabbitMq.class).run(args);
    }
}

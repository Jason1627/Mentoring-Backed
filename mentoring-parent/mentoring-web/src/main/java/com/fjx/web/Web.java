package com.fjx.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 20:42
 * @Author: Jason
 * @Description:
 */
@EnableZuulProxy
@SpringBootApplication
public class Web {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Web.class).run(args);
    }

}

package com.fjx.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import until.IdWorker;
import until.JwtUtil;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 20:00
 * @Author: Jason
 * @Description:
 */
public class User {

    public static void main(String[] args) {
        new SpringApplicationBuilder(User.class).run(args);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswodEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new until.JwtUtil();
    }
}

package com.fjx.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         // authorizeRequests 所有的 security 权直接配置实现的开端，表示开始说明需要的权限,需要的权限分为两部分，一部分是拦截路径，一部分是访问该路径需要权限
        // antMatchers  表示拦截什么路径，permitAll 表示任何权限都可以访问，直接放行所有的访问
        // anyRequest() 任何的请求 ，authenticated（） 认证后才可登陆
        // and().csrf().disable() 是固定写法 表示使csrf失效
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}

package com.fjx.sms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @program: mentoring-parent
 * @Date: 2020-08-23 19:33
 * @Author: Jason
 * @Description:
 */

@SpringBootApplication
public class Sms {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Sms.class).run(args);
    }
}

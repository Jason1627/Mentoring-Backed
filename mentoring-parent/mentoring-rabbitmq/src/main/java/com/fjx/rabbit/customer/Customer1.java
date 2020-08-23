package com.fjx.rabbit.customer;/*
 * @program: tensquare_parent
 * @Date: 2020-04-27 15:54
 * @Author: Jason
 * @Description:
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "danimic")
public class Customer1 {
    @RabbitHandler
    public void  showMessage(String message){
        System.out.println("danimic收到的消息为："+message);
    }
}

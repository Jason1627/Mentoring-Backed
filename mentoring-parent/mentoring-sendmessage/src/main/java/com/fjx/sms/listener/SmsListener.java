package com.fjx.sms.listener;/*
 * @program: tensquare_parent
 * @Date: 2020-04-28 10:28
 * @Author: Jason
 * @Description:
 */


import com.fjx.sms.untils.SmsUtil;
import com.netflix.client.ClientException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtill;

    @Value("${aliyun.sms.template_code}")
    private String template_code; // 模板编号
    @Value("${aliyun.sms.sign_name}")
    private String sing_name; // 签名

    @RabbitHandler
    public void  executeSms(Map<String,String> map){
        String mobile=map.get("mobile");
        String checkcode=map.get("checkcode");

        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码："+map.get("checkcode"));

        try {
            smsUtill.sendSms(mobile,template_code,sing_name,"{\"number\":\""+checkcode+"\"}");
        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
        }
    }

}

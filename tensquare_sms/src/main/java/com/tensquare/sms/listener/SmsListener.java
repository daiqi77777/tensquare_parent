package com.tensquare.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void executeSms(HashMap<String,String> map){
        System.out.println("******************************************");
        System.out.println("手机号"+map.get("phone"));
        System.out.println("验证码"+map.get("code"));
        System.out.println("******************************************");
    }
}

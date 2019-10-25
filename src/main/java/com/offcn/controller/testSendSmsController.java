package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class testSendSmsController {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @RequestMapping("/sendsms")
    public String sendSms(){
        Map map = new HashMap<>();
        map.put("mobile","18618187282");
        map.put("template_code","SMS_135036908");
        map.put("sign_name","面试宝典");
        map.put("param","{\"name\":\"2233\"}");
        jmsTemplate.convertAndSend("sms",map);
        return "发送短信成功";
    }

}

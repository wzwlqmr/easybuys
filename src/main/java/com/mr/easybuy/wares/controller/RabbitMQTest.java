package com.mr.easybuy.wares.controller;

import com.mr.easybuy.wares.util.rabbitMQ.ProducerSenderMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RabbitMQTest {
    @Autowired
    private ProducerSenderMQ producerSenderMQ;
    @GetMapping("testProcuceSend")
    public String testProcuceSend(){
        producerSenderMQ.sender("王志文说：咩好的事情即将发生");
        return "successfully";
    }
}

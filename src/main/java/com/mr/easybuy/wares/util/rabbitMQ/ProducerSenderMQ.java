package com.mr.easybuy.wares.util.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerSenderMQ {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /*/**
    * @Description: sender 发送消息
    * @Param: [msg]
    * @return: void
    * @Author: yxy
    * @Date: 2019/10/12
    */
    public void sender(String msg){
        //绑定消费程序到对应的exchange和queue
        amqpTemplate.convertAndSend("wzwExchange","wzwQueue.user",msg);
        System.out.println("发送:"+msg);
    }

}

package com.mr.easybuy.wares.util.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;


//@Configuration
public class TopicConfig {

    @Bean
    public Queue coreQueue(){
        return new Queue("wzwQueue");
    }
    //再设置一个queue 用来另一台接收
    /*@Bean
    public Queue coreQueue1(){
        return new Queue("wzwQueue1");
    }
*/
    @Bean
    public TopicExchange coreExchange(){
        return new TopicExchange("wzwExchange");
    }

    @Bean
    public Binding bindCoreQueueExchange(Queue coreQueue,TopicExchange coreExchange){
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("wzwQueue.*");
    }
    //再绑定一个routingkey
    @Bean
    public Binding bindCoreQueueExchange1(Queue coreQueue,TopicExchange coreExchange){
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("wzwQueue1.*");
    }
    //使用时监听不同的queue

}

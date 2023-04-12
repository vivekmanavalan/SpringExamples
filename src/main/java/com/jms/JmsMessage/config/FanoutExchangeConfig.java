package com.jms.JmsMessage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutExchangeConfig {

    @Bean
    Queue fanoutQueue(){
        return  new Queue("fan_out_queue");
    }

    @Bean
    Queue fanoutQueue1(){
        return new Queue("sample_queue");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fan_out_exchange");
    }

    @Bean
    public Binding fanoutBinding(Queue fanoutQueue, FanoutExchange exchange){
        return BindingBuilder.bind(fanoutQueue)
                .to(exchange);
    }


    //Since fanout will send to all queue associated with the exchange regardless of the routing key
    //we don't need to add routing key while binding
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange exchange1) {
        return BindingBuilder.bind(fanoutQueue1)
                .to(exchange1);
    }
}

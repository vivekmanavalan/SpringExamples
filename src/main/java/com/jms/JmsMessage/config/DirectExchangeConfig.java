package com.jms.JmsMessage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectExchangeConfig {

    @Bean
    public Queue directQueue(){
        return new Queue("direct_queue");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_exchange");
    }

    @Bean
    public Binding directBinding(Queue directQueue, DirectExchange exchange){
        return BindingBuilder.bind(directQueue)
                .to(exchange)
                .with("direct_routing");
    }
    /*@Bean
    MessageConverter directConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate template = new RabbitTemplate(factory);
        template.setMessageConverter(directConverter());
        return template;
    }*/
}

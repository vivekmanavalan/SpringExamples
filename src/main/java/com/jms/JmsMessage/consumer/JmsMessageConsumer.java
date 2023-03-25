package com.jms.JmsMessage.consumer;

import com.jms.JmsMessage.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    @RabbitListener(queues = "message_queue")
    public void consumeMessage(OrderStatus orderStatus){
        System.out.println("Received Order" + orderStatus.getOrderId() + orderStatus.getName() + orderStatus.getStatus());
    }
}

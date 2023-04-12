package com.jms.JmsMessage.consumer;

import com.jms.JmsMessage.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    /*@RabbitListener(queues = "message_queue")
    public void consumeMessage(OrderStatus orderStatus){
        System.out.println("Received Order" + orderStatus.getOrderId() + orderStatus.getName() + orderStatus.getStatus());
    }*/

    //Direct Exchange Listener
    @RabbitListener(queues = "direct_queue")
    public void consumeDirectMessage(OrderStatus orderStatus){
        System.out.println("Consumer called");
        System.out.println("Direct Exchange Order received" + orderStatus.getOrderId() +" Name: "+ orderStatus.getName() +" Status: " + orderStatus.getStatus());
    }

   @RabbitListener(queues = "fanout_queue")
    public void consumeFanoutMessage(OrderStatus orderStatus){
        System.out.println("Fanout Consumer called");
        System.out.println("Fanout Exchange Order received" + orderStatus.getOrderId() +" Name: "+ orderStatus.getName() +" Status: " + orderStatus.getStatus());
    }

   @RabbitListener(queues = "sample_queue")
    public void consumeFanoutSampleMessage(OrderStatus orderStatus){
        System.out.println("Fanout Consumer called");
        System.out.println("Fanout Sample Exchange Order received" + orderStatus.getOrderId() +" Name: "+ orderStatus.getName() +" Status: " + orderStatus.getStatus());
    }
}

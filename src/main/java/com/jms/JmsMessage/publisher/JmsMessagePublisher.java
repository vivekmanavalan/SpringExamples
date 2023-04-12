package com.jms.JmsMessage.publisher;

import com.jms.JmsMessage.dto.Order;
import com.jms.JmsMessage.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class JmsMessagePublisher {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping()
    public String getMessage(){
        return "Welcome to RabbitMQ";
    }

    @PostMapping("/default")
    public String bookOrder(@RequestBody Order order) {
        System.out.println("Message publisher");
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order.getOrderId(), order.getName(), "Completed");
        rabbitTemplate.convertAndSend("message_topic", "message_routingKey", orderStatus);
        return "Success";
    }

    @PostMapping("/direct")
    public String bookDirectOrder(@RequestBody Order order) {
        System.out.println("Direct message publisher");
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order.getOrderId(), order.getName(), "Completed");
        rabbitTemplate.convertAndSend("direct_exchange", "direct_routing", orderStatus);
        return "Directly delivered";
    }

    @PostMapping("/fanout")
    public String bookFanoutOrder(@RequestBody Order order) {
        System.out.println("Fanout message publisher");
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order.getOrderId(), order.getName(), "Completed");
        rabbitTemplate.convertAndSend("fan_out_exchange", "", orderStatus);
        return "Directly delivered";
    }
}

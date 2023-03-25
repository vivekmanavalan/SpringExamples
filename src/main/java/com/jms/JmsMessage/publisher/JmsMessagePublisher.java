package com.jms.JmsMessage.publisher;

import com.jms.JmsMessage.dto.Order;
import com.jms.JmsMessage.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class JmsMessagePublisher {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @PostMapping()
    public String bookOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        OrderStatus orderStatus = new OrderStatus(order.getOrderId(), order.getName(), "Completed");
        rabbitTemplate.convertAndSend("message_topic", "message_routingKey", orderStatus);
        return "Success";
    }
}

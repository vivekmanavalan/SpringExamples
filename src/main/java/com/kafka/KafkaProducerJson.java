package com.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerJson {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerJson.class);
    @Autowired
    private KafkaTemplate<String, Data> kafkaTemplate;

    public void sendMessage(Data data){
        Message<Data> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "crudJsonTopic")
                .build();

        kafkaTemplate.send(message);
    }
}

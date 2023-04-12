package com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @KafkaListener(topics = "crudTopic", groupId = "kafkaBasicGroup")
    public void getMessage(String message){
        LOGGER.info("Message received -> " + message);
    }

    @KafkaListener(topics = "crudJsonTopic", groupId = "kafkaJsonGroup")
    public void getJsonMessage(Data data){
        LOGGER.info("Message received from topic -> " + "Name: " + data.getName() + " Message: " + data.getMessage());
    }
}

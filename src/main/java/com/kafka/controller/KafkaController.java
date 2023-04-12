package com.kafka.controller;

import com.kafka.Data;
import com.kafka.KafkaProducer;
import com.kafka.KafkaProducerJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private KafkaProducerJson kafkaProducerJson;
    //http:localhost:8080/api/kafka/publish?message=welcome to kafka
    //getting data from query param
    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }

    @PostMapping("/publishJson")
    public ResponseEntity<String> publishMessage(@RequestBody Data data){
        kafkaProducerJson.sendMessage(data);
        return ResponseEntity.ok("Message sent to topic");
    }
}

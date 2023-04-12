package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic kafkaTopic(){
        return TopicBuilder.name("crudTopic")
                .partitions(2)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic kafkaJsonTopic(){
        return TopicBuilder.name("crudJsonTopic")
                .partitions(2)
                .replicas(1)
                .build();
    }
}

package com.kafka.poc.config;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "TestTopic", groupId = "group1")
    public void listen(String data) {
        System.out.println("Received from producer: " + data);
    }
}

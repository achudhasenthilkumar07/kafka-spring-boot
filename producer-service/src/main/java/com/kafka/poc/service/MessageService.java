package com.kafka.poc.service;

import com.kafka.poc.dto.ResponseDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

@Service
public class MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ResponseDTO messageContent() {
        final List<String> randomMessages = new ArrayList<>();
        randomMessages.add("Hi");
        randomMessages.add("Hope you are doing well");
        randomMessages.add("How about your job?");
        randomMessages.add("Did you get the hike?");
        randomMessages.add("What's new with you?");
        randomMessages.add("How is the project going?");
        randomMessages.add("Long time no see!");
        randomMessages.add("Are you free to chat?");
        final int randomNumber = RandomGenerator.getDefault().nextInt(randomMessages.size());
        this.kafkaTemplate.send("TestTopic", randomMessages.get(randomNumber));
        return new ResponseDTO("Success", "Message Sent Successfully", 200);
    }
}

package com.kafka.poc.controller;

import com.kafka.poc.dto.ResponseDTO;
import com.kafka.poc.service.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseDTO sendMessage() {
        return this.messageService.messageContent();
    }
}

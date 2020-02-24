package com.alan.developer.activemqclientms.controller;

import com.alan.developer.activemqclientms.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amq")
public class AMQController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @PostMapping("/send")
    public ResponseEntity sendMessage() {
        jmsTemplate.convertAndSend("queue", Email.builder().from("alan").to("queue").text("My email").build());
        return ResponseEntity.ok().build();
    }
}

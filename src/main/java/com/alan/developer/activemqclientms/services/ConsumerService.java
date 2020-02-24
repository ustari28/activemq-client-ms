package com.alan.developer.activemqclientms.services;

import com.alan.developer.activemqclientms.model.Email;
import lombok.extern.java.Log;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Log
public class ConsumerService {

    @JmsListener(destination = "queue", containerFactory = "myFactory")
    public void listener(Email message) {
        log.info("Message received -> " + message.toString());
    }
}

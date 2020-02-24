package com.alan.developer.activemqclientms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActivemqClientMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivemqClientMsApplication.class, args);
    }

}

package com.alan.developer.activemqclientms.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public class GenericConverter<T> implements MessageConverter {
    private final ObjectMapper mapper = new ObjectMapper();
    private Class<T> clazz;

    public GenericConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        String payload = null;
        try {
            payload = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        TextMessage message = session.createTextMessage();
        message.setText(payload);
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        TextMessage textMessage = (TextMessage) message;
        try {
            return mapper.readValue(textMessage.getText(), clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}

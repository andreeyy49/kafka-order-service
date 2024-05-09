package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageService {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${app.kafka.kafkaMessageTopicOrder}")
    private String statusTopic;


    @Autowired
    public KafkaMessageService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void add(Order message) {
        kafkaTemplate.send(statusTopic, message);
    }

}

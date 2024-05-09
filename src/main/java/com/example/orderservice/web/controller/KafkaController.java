package com.example.orderservice.web.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.KafkaMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order-service")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaMessageService kafkaMessageService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Order message) {
        kafkaMessageService.add(message);

        return ResponseEntity.ok().build();
    }
}

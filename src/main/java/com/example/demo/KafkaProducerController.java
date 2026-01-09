package com.example.demo;

import com.example.demo.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    private final KafkaProducerService producerService;

    public KafkaProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send")
    public String send(@RequestParam String msg) {
        producerService.sendMessage("demo-topic", msg);
        return "sent: " + msg;
    }
}

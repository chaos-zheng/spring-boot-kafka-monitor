package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.support.Acknowledgment;

@Component
public class KafkaConsumer {

    @KafkaListener(
        topics = "demo-topic",
        groupId = "demo-consumer-group"
    )
    public void consume(String message, Acknowledgment ack) {
        System.out.println("收到消息: " + message);
        ack.acknowledge();
    }


    // public void consume(String message) {
    //     System.out.println("收到消息: " + message);

    //     // 模拟消费慢一点，方便观察堆积
    //     try {
    //         Thread.sleep(1000);
    //     } catch (InterruptedException ignored) {
    //     }
    // }
}

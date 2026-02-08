package com.edigest.myFristproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "my-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // دالة لإرسال الرسالة
    public void writeMessage(String msg) {
        // إرسال الرسالة للـ Kafka
        this.kafkaTemplate.send(TOPIC, msg);

        // طباعة الرسالة في Console
        System.out.println("Message sent to Kafka: " + msg);
    }
}

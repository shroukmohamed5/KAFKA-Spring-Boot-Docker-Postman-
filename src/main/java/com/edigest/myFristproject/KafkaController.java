package com.edigest.myFristproject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducer producer;

    // Constructor injection
    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    // Endpoint لإرسال رسالة للـ Kafka topic
    @RequestMapping(value = "/send", method = { RequestMethod.GET, RequestMethod.POST})
    public String writeMessageToTopic(@RequestParam("message") String message) {
        producer.writeMessage(message);
        return "Message sent: " + message;
    }
}

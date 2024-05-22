package dev.sakshi.User.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaProducerClient {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerClient(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    // Message: jsonString of whatever data you want to send
    // {
    //   id: 1,
    //   name: Sakshi Jinnewar
    //   email: "sakshijinnewar@gmail.com"
    // }
}

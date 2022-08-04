package com.parika.payment.manager.config.kafkaTopicsConfiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class PaymentKafkaTopics {
    @Bean
    public NewTopic paymentCreateTopic(){
        return TopicBuilder.name("paymentCreateTopic").build();
    }
    @Bean
    public NewTopic paymentDeleteTopic(){
        return TopicBuilder.name("paymentDeleteTopic").build();
    }
    @Bean
    public NewTopic paymentUpdateTopic(){
        return TopicBuilder.name("paymentUpdateTopic").build();
    }
}

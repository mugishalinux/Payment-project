package com.parika.payment.manager.config.kafkaTopicsConfiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class PaymentTypeKafkaTopics {
    @Bean
    public NewTopic paymentTypeCreateTopic(){
        return TopicBuilder.name("paymentTypeCreateTopic").build();
    }
    @Bean
    public NewTopic paymentTypeDeleteTopic(){
        return TopicBuilder.name("paymentTypeDeleteTopic").build();
    }
    @Bean
    public NewTopic paymentTypeUpdateTopic(){
        return TopicBuilder.name("paymentTypeUpdateTopic").build();
    }
}

package com.parika.payment.manager.config.kafkaTopicsConfiguration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class PayableTypeKafkaTopics {
    @Bean
    public NewTopic payableTypeCreateTopic(){
        return TopicBuilder.name("payableTypeCreateTopic").build();
    }
    @Bean
    public NewTopic payableTypeDeleteTopic(){
        return TopicBuilder.name("payableTypeDeleteTopic").build();
    }
    @Bean
    public NewTopic payableTypeUpdateTopic(){
        return TopicBuilder.name("payableTypeDeleteTopic").build();
    }
}

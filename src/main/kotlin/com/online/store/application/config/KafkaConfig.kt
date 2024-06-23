package com.online.store.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
class KafkaConfig {

    @Bean
    fun orderComplete(): NewTopic {
        return TopicBuilder.name("orders-topic").build()
    }

}
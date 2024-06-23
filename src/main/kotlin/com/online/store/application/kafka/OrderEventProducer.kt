package com.online.store.application.kafka

import com.online.store.application.dto.kafka.OrderPlacedEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.support.MessageBuilder

object OrderEventProducer {
    private const val ORDER_TOPIC = "orders-topic"

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, OrderPlacedEvent>

    fun send(orderPlacedEvent: OrderPlacedEvent) {
        val message = MessageBuilder
            .withPayload(orderPlacedEvent)
            .setHeader(KafkaHeaders.TOPIC, ORDER_TOPIC)
            .build()
        kafkaTemplate.send(message)
    }
}
package com.online.store.application.dto.kafka

data class OrderPlacedEvent(
    val orderId: Long? = null,
    val orderPlaced: Boolean = true,
    val orderPlacedTime: Long = System.currentTimeMillis()
)

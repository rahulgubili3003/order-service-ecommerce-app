package com.online.store.application.dto.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class ProductItems(
    @field:NotNull
    val productId: String,
    @field:Positive(message = "The Quantity must be positive")
    val quantity: Int
)

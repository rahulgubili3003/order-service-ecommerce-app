package com.online.store.application.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import jakarta.validation.constraints.NotEmpty

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class PlaceOrder(
    @field:NotEmpty(message = "The selected products must not be empty")
    val productIds: List<ProductItems>
)

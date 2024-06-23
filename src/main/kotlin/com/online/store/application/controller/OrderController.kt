package com.online.store.application.controller

import com.online.store.application.dto.request.PlaceOrder
import com.online.store.application.dto.response.OkResponse
import com.online.store.application.service.OrderService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class OrderController(private val orderService: OrderService) {

    @PostMapping("/place-order")
    fun placeOrder(@Valid @RequestBody placeOrder: PlaceOrder): ResponseEntity<OkResponse> {
        val orderId = orderService.placeOrder(placeOrder)
        return ResponseEntity.ok(OkResponse(data = orderId))
    }
}
package com.online.store.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class OrderServiceEcommerceAppApplication

fun main(args: Array<String>) {
	runApplication<OrderServiceEcommerceAppApplication>(*args)
}

package com.online.store.application.repository

import com.online.store.application.entity.Orders
import org.springframework.data.jpa.repository.JpaRepository

interface OrdersRepository: JpaRepository<Orders, Long> {
}
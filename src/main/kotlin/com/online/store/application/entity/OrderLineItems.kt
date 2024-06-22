package com.online.store.application.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date

@Entity
@Table(name = "order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class OrderLineItems(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(name = "product_code")
    val productId: String,

    @Column(name = "quantity_ordered", nullable = false)
    val quantity: Int,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date = Date(),

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date = Date(),

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
)
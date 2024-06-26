package com.online.store.application.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
data class Orders(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    val id: Long? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    @Column(name = "products_list")
    val productsList: List<OrderLineItems>,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date? = null,

    @UpdateTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date? = null,

    @Column(name = "is_deleted")
    val isDeleted: Boolean = false
)
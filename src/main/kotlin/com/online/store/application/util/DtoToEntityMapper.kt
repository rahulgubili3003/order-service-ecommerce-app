package com.online.store.application.util

import com.online.store.application.dto.request.PlaceOrder
import com.online.store.application.entity.OrderLineItems
import com.online.store.application.entity.Orders

class DtoToEntityMapper {

    companion object {
        fun mapOrdersDtoToEntity(placeOrder: PlaceOrder): Orders {
            val orderLineItemsList = placeOrder.productIds.map { OrderLineItems(productId = it.productId, quantity = it.quantity) }

            // Create an Orders entity with the list of OrderLineItems
            return Orders(productsList = orderLineItemsList)
        }
    }
}
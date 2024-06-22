package com.online.store.application.service

import com.online.store.application.dataaccess.feign.ProductServiceFeign
import com.online.store.application.dto.request.GetInventoryDetails
import com.online.store.application.dto.request.PlaceOrder
import com.online.store.application.entity.Orders
import com.online.store.application.exception.OutOfStockException
import com.online.store.application.repository.OrdersRepository
import com.online.store.application.util.DtoToEntityMapper
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val ordersRepository: OrdersRepository,
    private val productServiceFeign: ProductServiceFeign
) {

    @Transactional
    fun placeOrder(placeOrder: PlaceOrder): Orders {
        val productRequestsMap = placeOrder.productIds.associateBy({ it.productId }, { it.quantity })
        val productIdList = placeOrder.productIds.stream().map { it.productId }.toList()
        val getInventoryDetails = GetInventoryDetails(
            productIdList = productIdList
        )
        val inventoryDetails = productServiceFeign.getInventory(getInventoryDetails)
        val outOfStockProductIds = inventoryDetails.filter { it.stockQty < (productRequestsMap[it.productId]?: Int.MAX_VALUE) }.map { it.productId }
        if (outOfStockProductIds.isNotEmpty()) {
            throw OutOfStockException("The following items are not present: $outOfStockProductIds")
        }
        val order = DtoToEntityMapper.mapOrdersDtoToEntity(placeOrder)
       return ordersRepository.save(order)
    }
}
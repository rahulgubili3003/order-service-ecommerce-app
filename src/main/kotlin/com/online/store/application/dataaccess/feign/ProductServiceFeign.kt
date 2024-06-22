package com.online.store.application.dataaccess.feign

import com.online.store.application.dataaccess.client.ProductServiceFeignClient
import com.online.store.application.dto.request.GetInventoryDetails
import com.online.store.application.dto.response.InventoryDetailsResponse
import com.online.store.application.exception.ApiServiceException
import feign.FeignException
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ProductServiceFeign(private val productServiceFeignClient: ProductServiceFeignClient) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun getInventory(getInventoryDetails: GetInventoryDetails): List<InventoryDetailsResponse> {
        try {
            return productServiceFeignClient.getInventory(getInventoryDetails.productIdList)
        } catch (fe: FeignException) {
            log.error("Feign Exception: {}", fe.message, fe)
            throw ApiServiceException("Feign Exception Occurred")
        } catch (ex: Exception) {
            log.error("Unexpected Exception: {}", ex.message, ex)
            throw ApiServiceException("Unexpected Exception")
        }
    }
}
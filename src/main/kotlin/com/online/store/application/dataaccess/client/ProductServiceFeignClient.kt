package com.online.store.application.dataaccess.client

import com.online.store.application.dto.response.InventoryDetailsResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "product-feign",
    url = "\${product-service-api.url}"
)
interface ProductServiceFeignClient {

    companion object {
        const val GET_INVENTORY = "api/v1/getInventory"
    }

    @GetMapping(value = [GET_INVENTORY], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getInventory(@RequestParam productsList: List<String>): List<InventoryDetailsResponse>
}
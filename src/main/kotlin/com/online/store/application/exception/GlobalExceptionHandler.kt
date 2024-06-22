package com.online.store.application.exception

import com.online.store.application.dto.response.error.ApiErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleApiExceptions(ex: ApiServiceException): ResponseEntity<ApiErrorResponse> {
        val errorResponse = ApiErrorResponse(
            errorCode = "001",
            errorMessage = "Api Server Call Failed",
            cause = ex.message?: "Could not call client"
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse)
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleOutOfStockException(ex: OutOfStockException): ResponseEntity<ApiErrorResponse> {
        val errorResponse = ApiErrorResponse(
            errorCode = "002",
            errorMessage = "Items out of stock",
            cause = ex.message?: "The items requested are out of stock"
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse)
    }
}
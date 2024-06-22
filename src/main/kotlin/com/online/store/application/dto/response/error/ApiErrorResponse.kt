package com.online.store.application.dto.response.error

data class ApiErrorResponse(
    val errorCode: String,
    val errorMessage: String,
    val cause: String
)

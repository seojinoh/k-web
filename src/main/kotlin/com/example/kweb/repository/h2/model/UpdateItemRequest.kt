package com.example.kweb.repository.h2.model

data class UpdateItemRequest(
    val id: Long,
    val description: String,
    val category: String,
    val price: Long?,
    val count: Long?
)

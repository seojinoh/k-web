package com.example.kweb.repository.h2.model

data class InsertItemRequest(
    val id: Long? = null,
    val name: String,
    val description: String,
    val category: String,
    val price: Long?,
    val count: Long?
)

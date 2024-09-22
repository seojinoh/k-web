package com.example.kweb.service

import com.example.kweb.domain.ManagedItem

interface UpdateItem {
    fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?,
    ): ManagedItem
}

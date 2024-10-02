package com.example.kweb.repository

import com.example.kweb.domain.Filter
import com.example.kweb.domain.ManagedItem

interface ItemRepository {
    fun readAllItems(): List<ManagedItem>

    fun readItemWithFilter(filter: Filter): List<ManagedItem>

    fun readItemById(id: Long): ManagedItem

    fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem

    fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem

    fun deleteItemById(id: Long): ManagedItem
}

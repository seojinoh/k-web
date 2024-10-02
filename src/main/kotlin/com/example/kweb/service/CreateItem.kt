package com.example.kweb.service

import com.example.kweb.domain.ManagedItem

interface CreateItem {
    fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem
}

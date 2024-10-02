package com.example.kweb.service

import com.example.kweb.domain.Filter
import com.example.kweb.domain.ManagedItem

interface ReadItem {
    fun readAllItems(): List<ManagedItem>

    fun readItemsWithFilter(filter: Filter): List<ManagedItem>

    fun readItemById(id: Long): ManagedItem
}

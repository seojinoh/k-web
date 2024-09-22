package com.example.kweb.service

import com.example.kweb.domain.Filter
import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class ReadItemService(
    private val itemRepository: ItemRepository
): ReadItem {
    override fun readAllItems(): List<ManagedItem> = itemRepository.readAllItems()

    override fun readItemsWithFilter(filter: Filter): List<ManagedItem> = itemRepository.readItemWithFilter(filter)

    override fun readItemById(id: Long): ManagedItem = itemRepository.readItemById(id)
}

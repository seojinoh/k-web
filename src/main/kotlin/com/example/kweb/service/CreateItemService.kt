package com.example.kweb.service

import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class CreateItemService(
    private val itemRepository: ItemRepository
): CreateItem {
    override fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem = itemRepository.createItem(name, description, category, price, count)
}

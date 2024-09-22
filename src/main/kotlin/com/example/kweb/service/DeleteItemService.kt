package com.example.kweb.service

import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class DeleteItemService(
    private val itemRepository: ItemRepository
): DeleteItem {
    override fun deleteItemById(id: Long): ManagedItem = itemRepository.deleteItemById(id)
}

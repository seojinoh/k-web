package com.example.kweb.service

import com.example.kweb.domain.ManagedItem
import com.example.kweb.error.model.ErrorMessage
import com.example.kweb.exception.custom.NotFoundException
import com.example.kweb.repository.ItemRepository
import org.springframework.stereotype.Service

@Service
class UpdateItemService(
    private val itemRepository: ItemRepository
): UpdateItem {
    override fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem =
        itemRepository.updateItemById(
            id,
            description,
            category,
            price,
            count
        ) ?: throw NotFoundException(message = ErrorMessage.ITEM_NOT_FOUND)
}

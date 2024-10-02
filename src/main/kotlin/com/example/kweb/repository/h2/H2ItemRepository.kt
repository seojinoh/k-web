package com.example.kweb.repository.h2

import com.example.kweb.domain.Filter
import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import com.example.kweb.repository.h2.model.InsertItemRequest
import com.example.kweb.repository.h2.model.ItemResult
import com.example.kweb.repository.h2.model.UpdateItemRequest
import org.springframework.stereotype.Repository

@Repository
class H2ItemRepository(
    private val h2ItemMapper: H2ItemMapper
) : ItemRepository {
    override fun readAllItems(): List<ManagedItem> = h2ItemMapper.readAllItems().map { itemResult ->
        ItemResult.toManagedItem(itemResult)
    }

    override fun readItemWithFilter(filter: Filter): List<ManagedItem> = h2ItemMapper.readItemWithFilter(
        limit = filter.pageSize,
        offset = (filter.page - 1) * filter.pageSize,
        search = filter.search ?: "",
    ).map { itemResult ->
        ItemResult.toManagedItem(itemResult)
    }

    override fun readItemById(id: Long): ManagedItem = ItemResult.toManagedItem(
        itemResult = h2ItemMapper.readItemById(id)
    )

    override fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?,
    ): ManagedItem {
        val insertItemRequest = InsertItemRequest(
            name = name,
            description = description,
            category = category,
            price = price,
            count = count,
        )
        h2ItemMapper.createItem(insertItemRequest)

        return readItemById(insertItemRequest.id!!)
    }

    override fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?,
    ): ManagedItem {
        val updateItemRequest = UpdateItemRequest(
            id = id,
            description = description,
            category = category,
            price = price,
            count = count,
        )
        h2ItemMapper.updateItemById(updateItemRequest)

        return readItemById(id)
    }

    override fun deleteItemById(id: Long): ManagedItem {
        val managedItem = readItemById(id)
        h2ItemMapper.deleteItemById(id)

        return managedItem
    }
}

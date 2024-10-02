package com.example.kweb.repository.h2.model

import com.example.kweb.domain.Item
import com.example.kweb.domain.ManagedItem
import java.sql.Timestamp

data class ItemResult(
    val id: Long,
    val createTimestamp: Timestamp,
    val price: Long?,
    val count: Long?,
    val name: String,
    val description: String,
    val category: String
) {
    companion object {
        fun toManagedItem(itemResult: ItemResult): ManagedItem = ManagedItem(
            id = itemResult.id,
            createTimestamp = itemResult.createTimestamp,
            price = itemResult.price,
            count = itemResult.count,
            item = Item(
                name = itemResult.name,
                description = itemResult.description,
                category = itemResult.category
            )
        )
    }
}

package com.example.kweb.repository.mock

import com.example.kweb.domain.Filter
import com.example.kweb.domain.Item
import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import java.sql.Timestamp
import java.time.Instant

class MockItemRepository: ItemRepository {
    companion object {
        private val managedItemMap: MutableMap<Long, ManagedItem> = mutableMapOf(
            1L to ManagedItem(
                id = 1,
                createTimestamp = Timestamp.from(Instant.parse("2024-01-01T00:00:00.000Z")),
                price = 119_000,
                count = 1,
                item = Item(
                    name = "Nike Cortez",
                    description = "275 mm",
                    category = "sneakers"
                )
            ),
            2L to ManagedItem(
                id = 2,
                createTimestamp = Timestamp.from(Instant.parse("2024-02-01T00:00:00.000Z")),
                price = 210_000,
                count = 1,
                item = Item(
                    name = "Dr. Martens 1461",
                    description = "265 mm",
                    category = "dress_shoes"
                )
            ),
            3L to ManagedItem(
                id = 3,
                createTimestamp = Timestamp.from(Instant.parse("2024-03-01T00:00:00.000Z")),
                price = 69_000L,
                count = 1,
                item = Item(
                    name = "Crocs Classic Clog",
                    description = "275 mm",
                    category = "sandals"
                )
            )
        )
    }

    override fun readAllItems(): List<ManagedItem> = managedItemMap.values.toList()
        .sortedByDescending { managedItem ->
            managedItem.id
        }

    override fun readItemWithFilter(filter: Filter): List<ManagedItem> {
        val filteredManagedItems = managedItemMap.values.toList()
            .filter { managedItem ->
                val search = filter.search ?: ""
                managedItem.item.name.contains(search)
                        || managedItem.item.description.contains(search)
                        || managedItem.item.category.contains(search)
            }
            .sortedByDescending { managedItem ->
                managedItem.id
            }

        val page = filter.page.toInt()
        val pageSize = filter.pageSize.toInt()
        val filteredCount = filteredManagedItems.size

        val fromIndex = (page - 1) * pageSize
        val toIndex = minOf(fromIndex + pageSize, filteredCount)

        return if (fromIndex < filteredCount) {
            filteredManagedItems.subList(fromIndex, toIndex)
        } else {
            emptyList()
        }
    }

    override fun readItemById(id: Long): ManagedItem? = managedItemMap[id]

    override fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem {
        val id = managedItemMap.keys.maxOrNull()?.let { maxId -> maxId + 1 } ?: 1
        val managedItem = ManagedItem(
                id,
                createTimestamp = Timestamp.from(Instant.now()),
                price,
                count,
                item = Item(
                    name,
                    description,
                    category
                )
            )
        managedItemMap[id] = managedItem

        return managedItem
    }

    override fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem? {
        val oldManagedItem = managedItemMap[id]

        return if (oldManagedItem != null) {
            val newManagedItem = oldManagedItem.copy(
                price = price,
                count = count,
                item = oldManagedItem.item.copy(
                    description = description,
                    category = category
                )
            )
            managedItemMap[id] = newManagedItem

            newManagedItem
        } else {
            null
        }
    }

    override fun deleteItemById(id: Long): ManagedItem? = managedItemMap[id]?.let { managedItem ->
        managedItemMap.remove(id)

        managedItem
    }
}

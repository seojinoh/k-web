package com.example.kweb.repository.mock

import com.example.kweb.domain.Filter
import com.example.kweb.domain.Item
import com.example.kweb.domain.ManagedItem
import com.example.kweb.repository.ItemRepository
import java.sql.Timestamp
import java.time.Instant

class MockItemRepository: ItemRepository {
    override fun readAllItems(): List<ManagedItem> = listOf(
        ManagedItem(
            id = 1,
            createTimestamp = Timestamp.from(Instant.parse("2024-01-01T00:00:00.000Z")),
            price = 119_000L,
            count = 1,
            item = Item(
                name = "Nike Cortez",
                description = "275 mm",
                category = "sneakers"
            )
        ),
        ManagedItem(
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
        ManagedItem(
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

    override fun readItemWithFilter(filter: Filter): List<ManagedItem> = listOf(
        ManagedItem(
            id = 1,
            createTimestamp = Timestamp.from(Instant.parse("2024-01-01T00:00:00.000Z")),
            price = 119_000L,
            count = 1,
            item = Item(
                name = "Nike Cortez",
                description = "275 mm",
                category = "sneakers"
            )
        ),
        ManagedItem(
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
        ManagedItem(
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

    override fun readItemById(id: Long): ManagedItem = ManagedItem(
        id = 1,
        createTimestamp = Timestamp.from(Instant.parse("2024-01-01T00:00:00.000Z")),
        price = 119_000L,
        count = 1,
        item = Item(
            name = "Nike Cortez",
            description = "275 mm",
            category = "sneakers"
        )
    )

    override fun createItem(
        name: String,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem = ManagedItem(
        id = 4,
        createTimestamp = Timestamp.from(Instant.parse("2024-04-01T00:00:00.000Z")),
        price = 139_000L,
        count = 1,
        item = Item(
            name = "Adidas Superstar",
            description = "275 mm",
            category = "sneakers"
        )
    )

    override fun updateItemById(
        id: Long,
        description: String,
        category: String,
        price: Long?,
        count: Long?
    ): ManagedItem = ManagedItem(
        id = 4,
        createTimestamp = Timestamp.from(Instant.parse("2024-04-01T00:00:00.000Z")),
        price = 139_000L,
        count = 1,
        item = Item(
            name = "Adidas Superstar",
            description = "275 mm",
            category = "sneakers"
        )
    )

    override fun deleteItemById(id: Long): ManagedItem = ManagedItem(
        id = 4,
        createTimestamp = Timestamp.from(Instant.parse("2024-04-01T00:00:00.000Z")),
        price = 139_000L,
        count = 1,
        item = Item(
            name = "Adidas Superstar",
            description = "275 mm",
            category = "sneakers"
        )
    )
}

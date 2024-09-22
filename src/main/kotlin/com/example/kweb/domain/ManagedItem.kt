package com.example.kweb.domain

import java.sql.Timestamp

data class ManagedItem(
    val id: Long,
    val createTimestamp: Timestamp,
    val price: Long?,
    val count: Long?,
    val item: Item,
)

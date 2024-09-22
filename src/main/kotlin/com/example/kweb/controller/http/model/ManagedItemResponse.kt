package com.example.kweb.controller.http.model

import com.example.kweb.controller.http.model.ItemFieldName.CREATE_DATETIME
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_CATEGORY
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_COUNT
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_DESCRIPTION
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_ID
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_NAME
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_PRICE
import com.example.kweb.domain.ManagedItem
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

data class ManagedItemResponse(
    @JsonProperty(ITEM_ID)
    val itemId: Long,
    @JsonProperty(CREATE_DATETIME)
    val createDatetime: String,
    @JsonProperty(ITEM_PRICE)
    val itemPrice: Long?,
    @JsonProperty(ITEM_COUNT)
    val itemCount: Long?,
    @JsonProperty(ITEM_NAME)
    val itemName: String,
    @JsonProperty(ITEM_DESCRIPTION)
    val itemDescription: String,
    @JsonProperty(ITEM_CATEGORY)
    val itemCategory: String,
) {
    companion object {
        private fun toDatetime(timestamp: Timestamp): String {
            val instant = timestamp.toInstant()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")

            return formatter.withZone(ZoneOffset.UTC).format(instant)
        }

        fun convert(managedItem: ManagedItem): ManagedItemResponse {
            return ManagedItemResponse(
                itemId = managedItem.id,
                createDatetime = toDatetime(timestamp = managedItem.createTimestamp),
                itemPrice = managedItem.price,
                itemCount = managedItem.count,
                itemName = managedItem.item.name,
                itemDescription = managedItem.item.description,
                itemCategory = managedItem.item.category,
            )
        }
    }
}

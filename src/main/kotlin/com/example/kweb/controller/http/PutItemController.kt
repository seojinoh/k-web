package com.example.kweb.controller.http

import com.example.kweb.controller.http.model.ItemErrorMessage
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_ID
import com.example.kweb.controller.http.model.ManagedItemResponse
import com.example.kweb.controller.http.model.PutItemRequest
import com.example.kweb.service.UpdateItem
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/v1")
class PutItemController(
    private val updateItem: UpdateItem
) {
    @PutMapping("/item/{$ITEM_ID}")
    fun putItemByItemId(
        @NotNull(message = ItemErrorMessage.ITEM_ID_NOT_NULL)
        @Min(1, message = ItemErrorMessage.ITEM_ID_RANGE)
        @PathVariable(ITEM_ID)
        itemId: Long?,

        @Validated
        @RequestBody
        body: PutItemRequest
    ): ManagedItemResponse = ManagedItemResponse.convert(
        managedItem = updateItem.updateItemById(
            id = itemId!!,
            description = body.itemDescription!!,
            category = body.itemCategory!!,
            price = body.itemPrice,
            count = body.itemCount
        )
    )
}

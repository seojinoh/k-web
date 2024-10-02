package com.example.kweb.controller.http

import com.example.kweb.controller.http.model.ItemErrorMessage
import com.example.kweb.controller.http.model.ItemFieldName
import com.example.kweb.controller.http.model.ManagedItemResponse
import com.example.kweb.service.DeleteItem
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/v1")
class DeleteItemController(
    private val deleteItem: DeleteItem
) {
    @DeleteMapping("/item/{${ItemFieldName.ITEM_ID}}")
    fun deleteItemByItemId(
        @NotNull(message = ItemErrorMessage.ITEM_ID_NOT_NULL)
        @Min(1, message = ItemErrorMessage.ITEM_ID_RANGE)
        @PathVariable(ItemFieldName.ITEM_ID)
        itemId: Long?
    ): ManagedItemResponse = ManagedItemResponse.convert(
        managedItem = deleteItem.deleteItemById(id = itemId!!)
    )
}

package com.example.kweb.controller.http

import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_ID_NOT_NULL
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_ID_RANGE
import com.example.kweb.controller.http.model.ItemErrorMessage.PAGE_RANGE
import com.example.kweb.controller.http.model.ItemErrorMessage.PAGE_SIZE_RANGE
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_ID
import com.example.kweb.controller.http.model.ItemFieldName.PAGE
import com.example.kweb.controller.http.model.ItemFieldName.PAGE_SIZE
import com.example.kweb.controller.http.model.ItemFieldName.QUERY
import com.example.kweb.controller.http.model.ManagedItemResponse
import com.example.kweb.domain.Filter
import com.example.kweb.service.ReadItem
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/v1")
class GetItemController(
    private val readItem: ReadItem
) {
    companion object {
        private const val DEFAULT_PAGE = 1L
        private const val DEFAULT_PAGE_SIZE = 10L
    }

    @GetMapping("/items/all")
    fun getAllItems(): List<ManagedItemResponse> = readItem.readAllItems().map { item ->
        ManagedItemResponse.convert(
            managedItem = item,
        )
    }

    @GetMapping("/items")
    fun getItemsWithFilter(
        @Min(1, message = PAGE_RANGE)
        @RequestParam(PAGE)
        page: Long? = DEFAULT_PAGE,

        @Min(1, message = PAGE_SIZE_RANGE)
        @Max(100, message = PAGE_SIZE_RANGE)
        @RequestParam(PAGE_SIZE)
        pageSize: Long? = DEFAULT_PAGE_SIZE,

        @RequestParam(QUERY)
        search: String?,
    ): List<ManagedItemResponse> = readItem.readItemsWithFilter(filter = Filter(page, pageSize, search)).map { item ->
        ManagedItemResponse.convert(
            managedItem = item,
        )
    }

    @GetMapping("/item/{$ITEM_ID}")
    fun getItemByItemId(
        @NotNull(message = ITEM_ID_NOT_NULL)
        @Min(1, message = ITEM_ID_RANGE)
        @PathVariable(ITEM_ID)
        itemId: Long?,
    ): ManagedItemResponse = ManagedItemResponse.convert(
        managedItem = readItem.readItemById(id = itemId!!),
    )
}

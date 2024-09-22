package com.example.kweb.controller.http

import com.example.kweb.controller.http.model.ManagedItemResponse
import com.example.kweb.controller.http.model.PostItemRequest
import com.example.kweb.service.CreateItem
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class PostItemController(
    private val createItem: CreateItem
) {
    @PostMapping("/item")
    fun postItem(
        @Validated
        @RequestBody
        body: PostItemRequest,
    ): ManagedItemResponse = ManagedItemResponse.convert(
        managedItem = createItem.createItem(
            name = body.itemName!!,
            description = body.itemDescription!!,
            category = body.itemCategory!!,
            price = body.itemPrice,
            count = body.itemCount,
        )
    )
}

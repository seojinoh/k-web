package com.example.kweb.controller.http.model

import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_CATEGORY_NOT_NULL
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_CATEGORY_SIZE
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_COUNT_RANGE
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_DESCRIPTION_NOT_NULL
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_DESCRIPTION_SIZE
import com.example.kweb.controller.http.model.ItemErrorMessage.ITEM_PRICE_RANGE
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class PutItemRequest(
    @field:NotNull(message = ITEM_DESCRIPTION_NOT_NULL)
    @field:Size(min = 1, max = 2000, message = ITEM_DESCRIPTION_SIZE)
    @JsonProperty(ItemFieldName.ITEM_DESCRIPTION)
    val itemDescription: String?,

    @field:NotNull(message = ITEM_CATEGORY_NOT_NULL)
    @field:Size(min = 1, max = 200, message = ITEM_CATEGORY_SIZE)
    @JsonProperty(ItemFieldName.ITEM_CATEGORY)
    val itemCategory: String?,

    @field:Min(0, message = ITEM_PRICE_RANGE)
    @JsonProperty(ItemFieldName.ITEM_PRICE)
    val itemPrice: Long?,

    @field:Min(0, message = ITEM_COUNT_RANGE)
    @JsonProperty(ItemFieldName.ITEM_COUNT)
    val itemCount: Long?
)

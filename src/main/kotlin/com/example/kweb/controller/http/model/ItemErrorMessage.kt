package com.example.kweb.controller.http.model

import com.example.kweb.controller.http.model.ItemFieldName.ITEM_CATEGORY
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_COUNT
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_DESCRIPTION
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_ID
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_NAME
import com.example.kweb.controller.http.model.ItemFieldName.ITEM_PRICE
import com.example.kweb.controller.http.model.ItemFieldName.PAGE
import com.example.kweb.controller.http.model.ItemFieldName.PAGE_SIZE

object ItemErrorMessage {
    const val PAGE_RANGE = "$PAGE must be greater than or equal to 1"
    const val PAGE_SIZE_RANGE = "$PAGE_SIZE must be between 1 and 100"

    const val ITEM_ID_NOT_NULL = "$ITEM_ID must be exist"
    const val ITEM_ID_RANGE = "$ITEM_ID must be greater than or equal to 1"
    const val ITEM_PRICE_RANGE = "$ITEM_PRICE must be greater than or equal to 0"
    const val ITEM_COUNT_RANGE = "$ITEM_COUNT must be greater than or equal to 0"

    const val ITEM_NAME_NOT_NULL = "$ITEM_NAME must be exist"
    const val ITEM_NAME_SIZE = "$ITEM_NAME must be between 1 and 200 characters"
    const val ITEM_DESCRIPTION_NOT_NULL = "$ITEM_DESCRIPTION must be exist"
    const val ITEM_DESCRIPTION_SIZE = "$ITEM_DESCRIPTION must be between 1 and 2000 characters"
    const val ITEM_CATEGORY_NOT_NULL = "$ITEM_CATEGORY must be exist"
    const val ITEM_CATEGORY_SIZE = "$ITEM_CATEGORY must be between 1 and 200 characters"
}

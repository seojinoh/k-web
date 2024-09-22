package com.example.kweb.service

import com.example.kweb.domain.ManagedItem

interface DeleteItem {
    fun deleteItemById(id: Long): ManagedItem
}

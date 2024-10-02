package com.example.kweb.domain

data class Filter(
    val page: Long,
    val pageSize: Long,
    val search: String?
)

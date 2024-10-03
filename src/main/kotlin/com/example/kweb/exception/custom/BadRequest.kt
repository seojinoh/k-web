package com.example.kweb.exception.custom

sealed class BadRequest(
    val name: String,
    message: String
): RuntimeException(message)

package com.example.kweb.exception.custom

import com.example.kweb.error.model.ErrorName

class InvalidArgumentException(
    name: String = ErrorName.INVALID_ARGUMENT,
    message: String = "Invalid argument provided."
): BadRequest(name, message)

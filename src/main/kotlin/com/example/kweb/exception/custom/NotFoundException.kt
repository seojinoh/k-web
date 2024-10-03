package com.example.kweb.exception.custom

import com.example.kweb.error.model.ErrorName

class NotFoundException(
    name: String = ErrorName.NOT_FOUND,
    message: String = "Not found."
): BadRequest(name, message)

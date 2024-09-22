package com.example.kweb.error

import com.example.kweb.error.model.ErrorName
import com.example.kweb.error.model.ErrorResponse
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.NoHandlerFoundException

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleConstraintViolationException(ex: ConstraintViolationException): ErrorResponse {
        val constraintViolation = ex.constraintViolations.firstOrNull()

        return ErrorResponse(
            name = ErrorName.INVALID_ARGUMENT,
            message = constraintViolation?.message,
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ErrorResponse {
        val fieldError = ex.bindingResult.fieldErrors.firstOrNull()

        return ErrorResponse(
            name = ErrorName.INVALID_ARGUMENT,
            message = fieldError?.defaultMessage,
        )
    }

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNoHandlerFoundException(ex: NoHandlerFoundException): ErrorResponse {
        return ErrorResponse(
            name = ErrorName.NOT_FOUND,
            message = ex.message,
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun handleGenericException(ex: Exception): ErrorResponse {
        return ErrorResponse(
            name = ErrorName.INTERNAL_SERVER_ERROR,
            message = ex.message,
        )
    }
}

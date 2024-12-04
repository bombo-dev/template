package com.bombo.template.controller

import com.bombo.template.logging.log
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import protocol.ResultResponse

@RestControllerAdvice
internal class InternalAdminApiControllerAdvice {

    private val log = log()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
        IllegalArgumentException::class
    )
    protected fun handleIllegalArgumentException(e: IllegalArgumentException): ResultResponse<Unit> {
        log.warn(e) { "Invalid parameter. message=${e.message}" }
        return ResultResponse.fail(e.message)
    }
}

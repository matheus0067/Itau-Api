package com.matheusroldao.transacoes_api.exception

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleInvalidJSON(ex: HttpMessageNotReadableException): ResponseEntity<Unit> {
        logger.error("Erro ao processar JSON: ${ex.message}")
        return ResponseEntity.badRequest().build()
    }
}
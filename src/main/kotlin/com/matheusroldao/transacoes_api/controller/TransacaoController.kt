package com.matheusroldao.transacoes_api.controller

import com.matheusroldao.transacoes_api.dto.TransacaoRequest
import com.matheusroldao.transacoes_api.model.Transacao
import com.matheusroldao.transacoes_api.storage.TransacaoStorage
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController
class TransacaoController {

    private val logger = LoggerFactory.getLogger(TransacaoController::class.java)

    @Operation(
        summary = "Criar nova transação",
        description = "Registra uma nova transação financeira"
    )
    @ApiResponses(
        ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
        ApiResponse(responseCode = "400", description = "Requisição inválida"),
        ApiResponse(responseCode = "422", description = "Transação inválida")
    )


    @PostMapping("/transacao")
    fun criarTransacao(@RequestBody transacaoRequest: TransacaoRequest): ResponseEntity<Unit> {
        logger.info("Recebendo transação: $transacaoRequest")

        if (transacaoRequest.valor == null || transacaoRequest.dataHora == null) {
            return ResponseEntity.badRequest().build()
        }

        if (transacaoRequest.valor < 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
        }

        val agora = OffsetDateTime.now(TransacaoStorage.clock)
        if (transacaoRequest.dataHora.isAfter(agora)) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build()
        }

        TransacaoStorage.add(Transacao(transacaoRequest.valor, transacaoRequest.dataHora))
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @DeleteMapping("/transacao")
    fun limparTransacoes(): ResponseEntity<Unit> {
        logger.info("Limpando todas as transações")
        TransacaoStorage.clear()
        return ResponseEntity.ok().build()
    }
}
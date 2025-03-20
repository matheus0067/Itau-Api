package com.matheusroldao.transacoes_api.controller

import com.matheusroldao.transacoes_api.dto.EstatisticaResponse
import com.matheusroldao.transacoes_api.storage.TransacaoStorage
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EstatisticaController {
    private val logger = LoggerFactory.getLogger(EstatisticaController::class.java)

    @GetMapping("/estatistica")
    fun getEstatistica(): EstatisticaResponse {
        logger.info("Calculando estatísticas")

        val transacoes = TransacaoStorage.getTransacoesRecentes(60)

        return if (transacoes.isEmpty()) {
            EstatisticaResponse(0, 0.0, 0.0, 0.0, 0.0)
        } else {
            val sum = transacoes.sumOf { it.valor }
            val avg = sum / transacoes.size
            val min = transacoes.minOf { it.valor }
            val max = transacoes.maxOf { it.valor }
            EstatisticaResponse(transacoes.size, sum, avg, min, max)
        }
    }
}
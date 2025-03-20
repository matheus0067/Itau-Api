package com.matheusroldao.transacoes_api.dto

import java.time.OffsetDateTime
import io.swagger.v3.oas.annotations.media.Schema

data class TransacaoRequest (

    @field:Schema(
        description = "Valor da transação (deve ser positivo)",
        example = "150.75",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val valor: Double?,

    @field:Schema(
        description = "Data e hora no formato ISO 8601",
        example = "2023-10-20T10:00:00-03:00",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val dataHora: OffsetDateTime?
)
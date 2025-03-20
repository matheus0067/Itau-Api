package com.matheusroldao.transacoes_api.model

import java.time.OffsetDateTime

data class Transacao(
    val valor: Double,
    val dataHora: OffsetDateTime
)
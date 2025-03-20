package com.matheusroldao.transacoes_api.dto

data class EstatisticaResponse(
    val count: Int,
    val sum: Double,
    val avg: Double,
    val min: Double,
    val max: Double,
)
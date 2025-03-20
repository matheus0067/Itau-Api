package com.matheusroldao.transacoes_api.storage

import com.matheusroldao.transacoes_api.model.Transacao
import java.time.Clock
import java.time.OffsetDateTime
import java.util.concurrent.ConcurrentLinkedQueue

object TransacaoStorage {
    private val  transacoes = ConcurrentLinkedQueue<Transacao>()
    var clock: Clock = Clock.systemUTC()

    fun add(transacao: Transacao) {
        transacoes.add(transacao)
    }

    fun clear() {
        transacoes.clear()
    }

    fun getTransacoesRecentes(segundos: Long): List<Transacao> {
        val agora = OffsetDateTime.now(clock)
        val limite = agora.minusSeconds(segundos)
        return transacoes.filter {it.dataHora.isAfter(limite)}
    }
}
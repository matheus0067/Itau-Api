package com.matheusroldao.transacoes_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.matheusroldao.transacoes_api.controller", "com.matheusroldao.transacoes_api.service"])
class TransacoesApiApplication

fun main(args: Array<String>) {
	runApplication<TransacoesApiApplication>(*args)
}


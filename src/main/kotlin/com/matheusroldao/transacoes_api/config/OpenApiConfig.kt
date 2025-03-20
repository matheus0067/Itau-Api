package com.matheusroldao.transacoes_api.config


import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("API de Transações Itaú")
                    .version("1.0.0")
                    .description("API para gerenciamento de transações e estatísticas")
            )
    }
}
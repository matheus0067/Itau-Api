package com.matheusroldao.transacoes_api

import com.matheusroldao.transacoes_api.dto.TransacaoRequest
import com.matheusroldao.transacoes_api.storage.TransacaoStorage
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.time.OffsetDateTime
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class TransacaoControllerIntegrationTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup() {
        TransacaoStorage.clear()
    }

    @Test
    fun `deve retornar 201 ao criar transacao valida`() {
        val transacaoValida = TransacaoRequest(100.0, OffsetDateTime.now())

        mockMvc.post("/transacao") {
            contentType = MediaType.APPLICATION_JSON
            content = """
                {
                    "valor": ${transacaoValida.valor},
                    "dataHora": "${transacaoValida.dataHora}"
                }
            """.trimIndent()
        }.andExpect {
            status { isCreated() }
        }
    }
}
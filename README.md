API REST de Transações Financeiras (Itaú Unibanco) 💻📊

Desenvolvi esta API REST como parte de um desafio técnico do Itaú Unibanco, com o objetivo de processar transações financeiras e gerar estatísticas em tempo real. A API foi projetada para ser escalável, segura e de fácil integração com sistemas front-end e mobile, garantindo um fluxo eficiente de dados entre as camadas do sistema.

🔧 Funcionalidades Principais

✅ Recebimento de Transações: Endpoint para processar transações financeiras em tempo real.

✅ Cálculo de Estatísticas: Geração de métricas como soma, média e contagem de transações.

✅ Limpeza de Dados: Endpoint para reinicialização e remoção de dados armazenados.

🛠️ Tecnologias Utilizadas

🚀 Kotlin & Spring Boot: Desenvolvimento da API, garantindo alta performance e manutenção simplificada.

📖 Swagger: Documentação interativa para facilitar a exploração dos endpoints.

🧪 JUnit & Mockito: Testes unitários para assegurar a qualidade e confiabilidade do código.

🛠 Docker: Ambiente conteinerizado para facilitar a execução do projeto.

⚙️ Como Executar o Projeto

1. Clonar o Repositório

git clone https://github.com/matheus0067/api-transacoes-financeiras.git
cd api-transacoes-financeiras

2. Construir e Executar com Docker (Recomendado)

docker-compose up --build

3. Executar Manualmente (Sem Docker)

Certifique-se de ter o Java 17+ e o Maven instalados.

./mvnw spring-boot:run

📑 Documentação com Swagger

Após iniciar a API, você pode acessar a documentação no seguinte link:

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

📈 Testando a API

1. Criar uma Transação

curl -X POST "http://localhost:8080/transactions" -H "Content-Type: application/json" -d '{
  "amount": 100.50,
  "timestamp": "2025-03-19T12:34:56.789Z"
}'

2. Obter Estatísticas

curl -X GET "http://localhost:8080/statistics"

3. Deletar Todas as Transações

curl -X DELETE "http://localhost:8080/transactions"

📅 Executando Testes

Para rodar os testes unitários:

./mvnw test

📌 Impacto

Esse projeto reforça minha capacidade de trabalhar com integração de sistemas e compreender o fluxo de dados entre back-end e front-end. Ele também demonstra minha versatilidade em trabalhar com diferentes tecnologias, complementando minha expertise em desenvolvimento Android e back-end Kotlin.

💪 Desenvolvido por Matheus Roldão

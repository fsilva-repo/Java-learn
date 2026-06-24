# Guia de Tratamento de Exceções - Spring Boot + Data JPA

Este documento descreve a estratégia padrão utilizada no projeto para tratamento e padronização de erros retornados pela API. O objetivo é garantir respostas consistentes, seguras e informativas para os clientes (Front-end).

## 1. Visão Geral da Arquitetura

O sistema utiliza o mecanismo de **`@ControllerAdvice`** e **`@ExceptionHandler`** do Spring Framework para centralizar a captura de exceções em toda a aplicação.

- **Componente Principal:** [`GlobalExceptionHandler`](/br/com/academia/app/exception/exceptionHandling/GlobalExceptionHandler.java)
- **Estratégia:** Captura exceções em diferentes camadas (Controller, Service, Repository/Data Access) e as mapeia para um objeto de resposta unificado (`ErrorResponse`).
- **Vantagens:**
  - Centralização da lógica de erro.
  - Separação clara entre dados sensíveis (stack trace interno) e mensagens de usuário.
  - Códigos HTTP consistentes (400, 404, 500, etc.).

## 2. Estrutura da Resposta de Erro

Todas as exceções capturadas retornam um JSON padronizado. Exemplo de payload:

```json
{
  "timestamp": "2026-06-14T14:30:00Z",
  "status": 404,
  "error": "Resource Not Found",
  "message": "Usuário não encontrado com ID 123",
  "path": "/api/v1/users/123"
}
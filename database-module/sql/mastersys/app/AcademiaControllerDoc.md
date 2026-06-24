# Documentação do AcademiaControllerDoc

Este arquivo explica como criar a documentação de API para o controller de relatórios da academia usando uma interface de documentação com Springdoc/OpenAPI.

## Como funciona

1. Crie uma interface de documentação em `app/src/main/java/br/com/academia/app/doc/AcademiaControllerDoc.java`.
2. Anote a interface com `@Tag` para agrupar os endpoints no Swagger/OpenAPI.
3. Declare métodos na interface com o mesmo nome e assinatura dos métodos do controller.
4. Use `@Operation` para descrever cada endpoint.
5. Use `@ApiResponse` para documentar os códigos de resposta e possíveis erros.
6. Use `@Parameter` e `@RequestBody` para descrever parâmetros de entrada e corpo de requisição.
7. Faça o controller implementar essa interface.

## Por que usar essa abordagem

- O Springdoc coleta as anotações da interface e gera a documentação OpenAPI para os endpoints.
- Mantém a documentação separada do código de implementação.
- Facilita a leitura e manutenção da documentação dos endpoints.
- Permite reaproveitar as descrições em controllers e manter os métodos do controller limpos.

## Exemplo de documentação para `AcademiaControllerDoc`

```java
package br.com.academia.app.doc;

import java.util.List;

import br.com.academia.app.projection.AlunosPorCidadeProjection;
import br.com.academia.app.projection.FaturaAbertaProjection;
import br.com.academia.app.projection.FaturamentoMensalProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Tag(name = "Academia",
 description = "Operações de consultas para fins de relatórios")
public interface AcademiaControllerDoc {

  @Operation(
    summary = "faturamento mensal",
    description = "retorna o faturamento mensal da academia",
    responses = {
      @ApiResponse(responseCode = "200", description = "Faturamento mensal retornado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
    })
  List<FaturamentoMensalProjection> faturamentoMensal();

  @Operation(
    summary = "faturas em aberto",
    description = "retorna a lista de faturas em aberto da academia",
    responses = {
      @ApiResponse(responseCode = "200", description = "Faturas em aberto retornadas com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
    })
  List<FaturaAbertaProjection> faturaAberta();

  @Operation(
    summary = "alunos por cidade",
    description = "retorna a quantidade de alunos agrupados por cidade",
    responses = {
      @ApiResponse(responseCode = "200", description = "Relatório de alunos por cidade retornado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
    })
  List<AlunosPorCidadeProjection> alunosPorCidade();
}
```

## Controller que implementa a interface

No controller, basta implementar a interface de documentação:

```java
@RestController
@RequestMapping("/api/v1/relatorios")
public class AcademiaRelatorioController implements AcademiaControllerDoc {

  private final RelatorioAcademiaProjectionRepository repository;

  @GetMapping("/faturamento-mensal")
  public List<FaturamentoMensalProjection> faturamentoMensal() {
    return repository.faturamentoMensal();
  }

  @GetMapping("/fatura-aberta")
  public List<FaturaAbertaProjection> faturaAberta() {
    return repository.faturaAberta();
  }

  @GetMapping("/alunos-por-cidade")
  public List<AlunosPorCidadeProjection> alunosPorCidade() {
    return repository.alunosPorCidade();
  }
}
```

## Observações

- Cada método do controller deve ter o mesmo nome e mesma assinatura declarada na interface.
- O Springdoc usa essas anotações para gerar a documentação Swagger/OpenAPI.
- É possível adicionar mais detalhes, como exemplos de resposta e esquemas para objetos retornados.

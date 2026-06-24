package br.com.academia.app.doc;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.academia.app.dto.request.AlunoFiltroRequest;
import br.com.academia.app.dto.request.AlunoRequest;
import br.com.academia.app.dto.response.AlunoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@Tag(name = "Alunos", description = "Operações para, cadastros, consultas"
    + ", atualizações, exclusões, e filtragem de alunos")
public interface AlunoControllerDoc {
  @Operation(
    summary = "cadastrar aluno",
    description = "cria um novo aluno no sistema de academia",
    responses = {
      @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
  })
  // observeção os metodos devem term o mesmo nome do controller,
  // para que o springdoc gere a documentação corretamente
  AlunoResponse cadastrar(
      @Valid
      @RequestBody(
        description = "Dados do aluno a ser cadastrado",
        required = true,
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = AlunoRequest.class),
          examples = @ExampleObject(
            name = "Exemplo de requisição",
            value =
              """
              {
                "id": 8,
                "nome": "Larissa Dias Martins",
                "email": "larissa.dias@email.com",
                "telefone": null,
                "celular": "021-99800-0008",
                "cpf": "890.123.456-08",
                "genero": "F",
                "observacao": null,
                "dataNascimento": "1997-12-02",
                "endereco": "Rua Conde de Bonfim",
                "numero": "450",
                "bairro": "Tijuca",
                "cidade": "Rio de Janeiro",
                "estado": "RJ",
                "complemento": null,
                "cep": "20520-054",
                "criadeEm": "2024-04-10T10:00:00",
                "atualizadoEm": null
              }       
              """
  )))
  AlunoRequest request);

  @Operation(
    summary = "listar alunos",
    description = "retorna uma lista paginada de alunos cadastrados no sistema de academia,"
    + " filtros opcionais podem ser aplicados para refinar a busca como nome, genero, cidade, estado e cep",
    responses = {
      @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso"),
      @ApiResponse(responseCode = "400",
        description = "Erro de validação",
        content = @Content(
          mediaType = "application/json",
          schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))}
  )
  Page<AlunoResponse> listar(
    @Parameter(description = "Filtros opcionais para a listagem")
    AlunoFiltroRequest filtro,

    @Parameter(description = "Parâmetros de paginação e ordenação")
    Pageable pageable
  );


  @Operation(summary = "buscar aluno por ID",
  description = "retorna os dados de um aluno especifico com base no ID fornecido",
  responses = {
    @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
    @ApiResponse(
      responseCode = "400",
      description = "Aluno não encontrado",
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class))
    ) })
  AlunoResponse buscarAlunoPorId(
    @Parameter(description = "ID do aluno a ser buscado", example = "1", required = true)
    Long id
  );

  @Operation(summary = "atualizar aluno",
  description = "atualizar os dados de um aluno no sistema de academia",
  responses = {
      @ApiResponse(responseCode = "204", description = "Aluno atualizado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Erro de validação",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
  })
  AlunoResponse atualizar(
    @PathVariable Long id,
    @Valid
    @RequestBody(
      description = "Dados do aluno a ser atualizado",
      required = true,
      content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = AlunoRequest.class),
        examples = @ExampleObject(
          name = "Exemplo de requisição",
          value =
            """
          {
            "id": 8,
            "nome": "Larissa Dias Martins",
            "email": "larissa.dias@email.com",
            "telefone": null,
            "celular": "021-99800-0008",
            "cpf": "890.123.456-08",
            "genero": "F",
            "observacao": null,
            "dataNascimento": "1997-12-02",
            "endereco": "Rua Conde de Bonfim",
            "numero": "450",
            "bairro": "Tijuca",
            "cidade": "Rio de Janeiro",
            "estado": "RJ",
            "complemento": null,
            "cep": "20520-054",
            "criadeEm": "2024-04-10T10:00:00",
            "atualizadoEm": null
          }
            """
    )))
    AlunoRequest request);


  @Operation(summary = "deletar aluno",
  description = "remove um aluno do sistema de academia com base no ID fornecido",
  responses = {
      @ApiResponse(responseCode = "204", description = "Aluno deletado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Aluno não encontrado",
      content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
  })
  void deletar(
    @Parameter(description = "ID do aluno a ser deletado", example = "1", required = true)
    Long id
  );
}

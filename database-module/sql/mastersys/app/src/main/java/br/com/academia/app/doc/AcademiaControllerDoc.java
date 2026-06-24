package br.com.academia.app.doc;

import java.util.List;

import br.com.academia.app.projection.AlunosPorCidadeProjection;
import br.com.academia.app.projection.FaturaAbertaProjection;
import br.com.academia.app.projection.FaturamentoMensalProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Academia", description = "Operações de consultas para fins de ralatorios")
public interface AcademiaControllerDoc {


 @Operation(
  summary = "faturamento mensal",
  description = "retorna o faturamento mensal da academia",
  responses = {
   @ApiResponse(responseCode = "200", description = "Faturamento mensal retornado com sucesso"),
   @ApiResponse(responseCode = "400", description = "Erro de validação",
   content = @Content(mediaType = "application/json",
   schema = @Schema(implementation = br.com.academia.app.dto.response.ErrorResponse.class)))
 })
 public List<FaturamentoMensalProjection> faturamentoMensal();


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
 public List<FaturaAbertaProjection> faturaAberta();



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
 public List<AlunosPorCidadeProjection> alunosPorCidade();

}

package br.com.academia.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academia.app.doc.AcademiaControllerDoc;
import br.com.academia.app.projection.AlunosPorCidadeProjection;
import br.com.academia.app.projection.FaturaAbertaProjection;
import br.com.academia.app.projection.FaturamentoMensalProjection;
import br.com.academia.app.repository.RelatorioAcademiaProjectionRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
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

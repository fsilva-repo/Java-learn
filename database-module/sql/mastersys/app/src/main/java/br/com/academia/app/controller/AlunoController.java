package br.com.academia.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.academia.app.doc.AlunoControllerDoc;
import br.com.academia.app.dto.request.AlunoFiltroRequest;
import br.com.academia.app.dto.request.AlunoRequest;
import br.com.academia.app.dto.response.AlunoResponse;
import br.com.academia.app.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/alunos")
@RequiredArgsConstructor
public class AlunoController implements AlunoControllerDoc {

 private final AlunoService alunoService;
 
 @GetMapping
 public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
  return alunoService.listar(filtro, pageable);
 }

 @GetMapping("/{id}")
 public AlunoResponse buscarAlunoPorId(@PathVariable Long id) {
  return alunoService.buscarAlunoPorId(id);
 }
 
 @PostMapping("/cadastrar")
 @ResponseStatus(HttpStatus.CREATED)
 public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest request) {
  return alunoService.cadastrar(request);
 }

 @PutMapping("/atualizar/{id}")
 public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest request) {
  return alunoService.atualizar(id, request);
 }

 @DeleteMapping("/deletar/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
 public void deletar(@PathVariable Long id) {
  AlunoResponse alunoResponse = buscarAlunoPorId(id);
  alunoService.excluirAluno(alunoResponse.id());
 }



}












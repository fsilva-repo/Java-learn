package br.com.academia.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.academia.app.domain.Aluno;
import br.com.academia.app.dto.request.AlunoFiltroRequest;
import br.com.academia.app.dto.request.AlunoRequest;
import br.com.academia.app.dto.response.AlunoResponse;
import br.com.academia.app.exception.BusinessException;
import br.com.academia.app.exception.ResourceNotFoundException;
import br.com.academia.app.repository.jpa.AlunoRepository;
import br.com.academia.app.specification.AlunoSpecification;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AlunoService {
 private final AlunoRepository alunoRepository;

 /* Método para validar os dados do aluno antes de cadastrar ou atualizar
  * Verifica se o CPF é nulo ou já existe no banco de dados
  * Verifica se o email é nulo ou já existe no banco de dados
  * Lança uma ServiceHandlingException com a mensagem apropriada se alguma das validações falhar
 */

 private void alunoValidacao(AlunoRequest request) {
   // O serviço não vai ser iniciado se o campo obrigatorio estiver nulo
  if (request.cpf() == null) {
   throw new BusinessException("Campo cpf não pode ser nulo");
  }// O serviço não não vai ser concluido se o valor do campo já existir no banco de dados
  if (alunoRepository.existsByCpf(request.cpf())) {
   throw new BusinessException("CPF já cadastrado");
  }
  if (request.email() == null) {
   throw new BusinessException("Campo email não pode ser nulo");
  }
  if (alunoRepository.existsByEmail(request.email())) {
   throw new BusinessException("Email já cadastrado");
  }
 }

  // Método para buscar um aluno existente
 public Aluno buscarPorId(Long id) {
    return alunoRepository.findById(id)
        .orElseThrow(() ->
             new ResourceNotFoundException(
                "Aluno não encontrado com id: " + id
            ));
 }

 public AlunoResponse cadastrar(AlunoRequest request) {
  alunoValidacao(request);
  Aluno aluno = request.toEntity();
  Aluno alunoSalvo = alunoRepository.save(aluno);
  return AlunoResponse.fromEntity(alunoSalvo);
 }
 


 public AlunoResponse buscarAlunoPorId(Long id) {
  Aluno aluno = buscarPorId(id);
  return AlunoResponse.fromEntity(aluno);
 }

 public Page<AlunoResponse> listar(AlunoFiltroRequest request ,Pageable pageable) {
  Page<Aluno> alunos = alunoRepository.findAll(AlunoSpecification.filtrado(request),pageable);
  return alunos.map(AlunoResponse::fromEntity);
 }

 public AlunoResponse atualizar(Long id, AlunoRequest request) {
  Aluno aluno = buscarPorId(id);
  request.preencherCampos(aluno);
  Aluno alunoAtualizado = alunoRepository.save(aluno);
  return AlunoResponse.fromEntity(alunoAtualizado);
  
 }

 public void excluirAluno(Long id) {
  Aluno aluno = buscarPorId(id);
  alunoRepository.delete(aluno);
 }

}
 

















package br.com.academia.app.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.academia.app.domain.Aluno;

public record AlunoResponse(
 Long id,
 String nome,
 String email,
 String telefone,
 String celular,
 String cpf,
 String genero,
 String observacao,
 LocalDate dataNascimento,
 String endereco,
 String numero,
 String bairro,
 String cidade,
 String estado,
 String complemento,
 String cep,
 LocalDateTime criadeEm,
 LocalDateTime atualizadoEm
) {
 public static AlunoResponse fromEntity(Aluno aluno) {
  return new AlunoResponse(
   aluno.getId(),
   aluno.getNome(),
   aluno.getEmail(),
   aluno.getTelefone(),
   aluno.getCelular(),
   aluno.getCpf(),
   aluno.getGenero(),
   aluno.getObservacao(),
   aluno.getDataNascimento(),
   aluno.getEndereco(),
   aluno.getNumero(),
   aluno.getBairro(),
   aluno.getCidade(),
   aluno.getEstado(),
   aluno.getComplemento(),
   aluno.getCep(),
   aluno.getCriadoEm(),
   aluno.getAtualizadoEm()
  );
 }
}

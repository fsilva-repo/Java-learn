package br.com.academia.app.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import br.com.academia.app.domain.Aluno;

public record AlunoRequest(
 @NotBlank(message = "O nome é obrigatório")
 @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
 String nome,
 @NotBlank(message = "O email é obrigatório")
 @Email(message = "O email deve ser válido")
 String email,
 String telefone,
 @NotBlank(message = "O celular é obrigatório")
 @Size(max = 15, message = "O celular deve ter no máximo 15 caracteres")
 String celular,
 @NotBlank(message = "O CPF é obrigatório")
 @Size(max = 14, message = "O CPF deve ter no máximo 14 caracteres")
 String cpf,
 @Size(max = 1, message = "O gênero deve ter no máximo 1 caractere")
 String genero,
 @Size(max = 255, message = "A observação deve ter no máximo 255 caracteres")
 String observacao,
 @Past(message = "A data deve ser anterior à data atual")
 LocalDate dataNascimento,
 @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
 String endereco,
 @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
 String numero,
 @Size(max = 100, message = "O bairro deve ter no máximo 100 caracteres")
 String bairro,
 @Size(max = 100, message = "A cidade deve ter no máximo 100 caracteres")
 String cidade,
 @Size(max = 100, message = "O estado deve ter no máximo 100 caracteres")
 String estado,
 @Size(max = 255, message = "O complemento deve ter no máximo 255 caracteres")
 String complemento,
 @Size(max = 20, message = "O CEP deve ter no máximo 20 caracteres")
 String cep,
 LocalDateTime criadeEm,
 LocalDateTime atualizadoEm
) {

 public Aluno toEntity() {
  Aluno aluno = new Aluno();
  preencherCampos(aluno);
  return aluno;
 }

 public void preencherCampos(Aluno aluno) {
  aluno.setNome(this.nome);
  aluno.setEmail(this.email);
  aluno.setTelefone(this.telefone);
  aluno.setCelular(this.celular);
  aluno.setCpf(this.cpf);
  aluno.setGenero(this.genero);
  aluno.setObservacao(this.observacao);
  aluno.setDataNascimento(this.dataNascimento);
  aluno.setEndereco(this.endereco);
  aluno.setNumero(this.numero);
  aluno.setBairro(this.bairro);
  aluno.setCidade(this.cidade);
  aluno.setEstado(this.estado);
  aluno.setComplemento(this.complemento);
  aluno.setCep(this.cep);
  aluno.setCriadoEm(this.criadeEm);
  aluno.setAtualizadoEm(this.atualizadoEm);
 }
}

























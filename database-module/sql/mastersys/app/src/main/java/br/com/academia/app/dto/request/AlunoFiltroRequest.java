package br.com.academia.app.dto.request;
// dto criado para usar com a class AlunoSpecification
public record AlunoFiltroRequest(
 String nome,
 String genero,
 String endereco,
 String cidade,
 String estado,
 String cep
) {

}

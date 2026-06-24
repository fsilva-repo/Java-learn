package br.com.academia.app.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.academia.app.domain.Aluno;
import br.com.academia.app.dto.request.AlunoFiltroRequest;

public class AlunoSpecification {

 public static Specification<Aluno> filtrado(AlunoFiltroRequest filtro){
  return Specification.where(nomeContem(filtro.nome()))
  .and(generoContem(filtro.genero()))
  .and(enderecoContem(filtro.endereco()))
  .and(cidadeContem(filtro.cidade()))
  .and(estadoContem(filtro.estado()))
  .and(cepContem(filtro.cep()));
 }

 private static Specification<Aluno> nomeContem(String nome) {
  return (root, query, cb) -> {
   if (nome == null || nome.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
  };
 }
 
 private static Specification<Aluno> generoContem(String genero) {
  return (root, query, cb) -> {
   if (genero == null || genero.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("genero")), "%" + genero.toLowerCase() + "%");
  };
 }

 private static Specification<Aluno> enderecoContem(String endereco) {
    return (root, query, cb) -> {
   if (endereco == null || endereco.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("endereco")), "%" + endereco.toLowerCase() + "%");
  };
 }
 
 private static Specification<Aluno> cidadeContem(String cidade) {
    return (root, query, cb) -> {
   if (cidade == null || cidade.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("cidade")), "%" + cidade.toLowerCase() + "%");
  };
 }
 
 private static Specification<Aluno> estadoContem(String estado) {
    return (root, query, cb) -> {
   if (estado == null || estado.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("estado")), "%" + estado.toLowerCase() + "%");
  };
 }
 
 private static Specification<Aluno> cepContem(String cep) {
    return (root, query, cb) -> {
   if (cep == null || cep.isBlank()) {
    return null;
   }
   return cb.like(cb.lower(root.get("cep")), "%" + cep.toLowerCase() + "%");
  };
 }


}







package br.com.academia.app.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.academia.app.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno , Long>,
 JpaSpecificationExecutor<Aluno> {
 public static final List<Aluno> findByNome = null;


 
 // Verificar se o CPF ou email já existe no banco de dados
 Boolean existsByCpf(String cpf);
 Boolean existsByEmail(String email);

}

package br.com.academia.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academia.app.domain.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}

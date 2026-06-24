package br.com.academia.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academia.app.domain.Modalidade;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {

}

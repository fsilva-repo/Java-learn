package br.com.academia.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academia.app.domain.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {

}

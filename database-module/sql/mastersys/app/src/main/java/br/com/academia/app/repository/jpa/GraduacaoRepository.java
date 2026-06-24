package br.com.academia.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academia.app.domain.Graduacao;

public interface GraduacaoRepository extends JpaRepository<Graduacao, Long> {

}

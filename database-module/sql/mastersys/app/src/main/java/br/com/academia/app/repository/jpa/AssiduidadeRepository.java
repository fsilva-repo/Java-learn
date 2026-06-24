package br.com.academia.app.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.academia.app.domain.Assiduidade;

public interface AssiduidadeRepository extends JpaRepository<Assiduidade, Long> {

}

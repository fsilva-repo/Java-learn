package br.com.program.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.program.application.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {}
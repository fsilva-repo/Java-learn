package br.com.program.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.program.application.entities.Product;

// O JpaRepository contem todos os metodos para a comunicação com o banco de dados
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}

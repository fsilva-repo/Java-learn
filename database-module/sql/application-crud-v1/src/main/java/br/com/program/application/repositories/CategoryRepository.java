package br.com.program.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.program.application.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  boolean existsByName(String name);
}

package br.com.program.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.program.application.entities.Category;
import br.com.program.application.repositories.CategoryRepository;

@Service
public class CategoryService {

  private final CategoryRepository repository;

  public CategoryService(CategoryRepository repository) {
    this.repository = repository;
  }

  public Category save(Category category) {
    // avalia se a categoria já existe
    if (repository.existsByName(category.getName())) {
      throw new RuntimeException("Categoria já cadastrada");
    }

    category.setId(null);

    return repository.save(category);
  }

  public List<Category> findAll() {
    return repository.findAll();
  }

  public Category findById(Long id) {
    // lança um erro se a categoria não exista
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
  }

  
}

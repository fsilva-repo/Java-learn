package br.com.program.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.program.application.entities.Category;
import br.com.program.application.services.CategoryService;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

  private final CategoryService service;

  public CategoryController(CategoryService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {

    Category saved = service.save(category);

    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }
}

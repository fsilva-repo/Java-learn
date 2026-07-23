package br.com.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.responseEntity.CategoryResponseDTO;
import br.com.api.service.CategoryService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

 private final CategoryService categoryService;

  // resgatar a lista de todas as categorias
  @GetMapping
  public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
   List<CategoryResponseDTO> list = categoryService.findAllCategories();
   return ResponseEntity.ok().body(list);
  }
}

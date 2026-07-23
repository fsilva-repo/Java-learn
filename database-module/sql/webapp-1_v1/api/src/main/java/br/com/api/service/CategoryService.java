package br.com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.api.dto.responseEntity.CategoryResponseDTO;
import br.com.api.entities.Category;
import br.com.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

 private final CategoryRepository categoryRepository;

 // lista todos os produtos do banco de dados, convertendo-os para um DTO antes de retornar
 public List<CategoryResponseDTO> findAllCategories() {
  List<Category> categories = categoryRepository.findAll();
  return categories.stream()
   .map(this::convertToDTO)
   .toList();
 }
 // Método auxiliar para fazer o mapeamento manual
 private CategoryResponseDTO convertToDTO(Category category) {
  return new CategoryResponseDTO(
   category.getId(),
   category.getName()
  );
 }

}

package br.com.api.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import br.com.api.dto.responseEntity.CategoryResponseDTO;
import br.com.api.dto.responseEntity.ProductResponseDTO;
import br.com.api.entities.Product;
import br.com.api.repository.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

 private final ProductRepository productRepository;

 // lista todos os produtos do banco de dados, convertendo-os para um DTO antes de retornar
 public List<ProductResponseDTO> findAllProducts() {
  List<Product> products = productRepository.findAll();
  return products.stream()
   .map(this::convertToDTO)
   .toList();
 }
 // Método auxiliar para fazer o mapeamento manual
 private ProductResponseDTO convertToDTO(Product product) {
 Set<CategoryResponseDTO> categoriesDTO = product.getCategories()
  .stream()
  .map(cat -> new CategoryResponseDTO(cat.getId(), cat.getName()))
  .collect(Collectors.toSet());

 return new ProductResponseDTO(
  product.getId(),
  product.getName(),
  product.getDescription(),
  product.getPrice(),
  product.getImageUrl(),
  categoriesDTO,
  product.getOrders().stream()
   .map(order -> order.getId())
   .collect(Collectors.toSet())
 );
 }
}

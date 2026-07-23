package br.com.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.responseEntity.ProductResponseDTO;
import br.com.api.service.ProductService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

 private final ProductService productService;

  // resgatar a lista de todos os produtos
  @GetMapping
  public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
   List<ProductResponseDTO> list = productService.findAllProducts();
   return ResponseEntity.ok().body(list);
  }
}

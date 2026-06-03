package br.com.program.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.program.application.entities.Product;
import br.com.program.application.services.ProductService;

@RestController
@RequestMapping(value = "/produtos")
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }
  

  @GetMapping // busca por todos os produtos
  public List<Product> list() {
      return service.findAll();
  }

  @GetMapping("/{id}") // busca por um produto
  public Product findById(@PathVariable Long id) {
      return service.findById(id);
  }

  @PutMapping("/{id}") // atualiza um produto
  public Product update(
          @PathVariable Long id,
          @RequestBody Product product) {
      return service.update(id, product);
  }

  @DeleteMapping("/{id}") // deleta um produto
  public void delete(@PathVariable Long id) {
      service.delete(id);
  }

  
  @PostMapping// cria novo cliente
  public ResponseEntity<Product> create(@RequestBody Product product) {
    Product productSalvad = service.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(productSalvad);
  }
}

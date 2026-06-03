package br.com.program.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.program.application.entities.Product;
import br.com.program.application.repositories.ProductRepository;

// Os metodos disponiveis da camada de servico de Product
@Service
public class ProductService {

  private final ProductRepository repository;
  // injecao de dependencia via contrutor padrao moderno do spring boot
  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }
  

  public Product save(Product product) {
    /* Aqui define um id null quando precisar enviar um novo produto
      para a tebela produtos que define um id autogerado, assim prevenindo erros */
    product.setId(null);
    return repository.save(product);
  }

  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("produto não encontrado"));
  }

  public Product update(Long id, Product product) {

    Product existing = findById(id);

    existing.setCategory(product.getCategory());
    existing.setName(product.getName());
    existing.setPrice(product.getPrice());
    existing.setStock(product.getStock());

    return repository.save(existing);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

}

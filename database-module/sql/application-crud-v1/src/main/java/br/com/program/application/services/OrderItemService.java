package br.com.program.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.program.application.entities.OrderItem;
import br.com.program.application.repositories.OrderItemRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemService {
  private final OrderItemRepository repository;

  public OrderItemService(OrderItemRepository repository) {
    this.repository = repository;
  }
  
  public OrderItem save(OrderItem c) {
    c.setId(null);
    return repository.save(c);
  }

  public List<OrderItem> findAll() {
    return repository.findAll();
  }

  public OrderItem findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("itens não encontrado"));
  }


  public OrderItem update(Long id, OrderItem item) {
    // lança uma exception se o id não existir
    OrderItem existing = findById(id);

    existing.setOrder(item.getOrder());
    existing.setProduct(item.getProduct());
    existing.setQuantity(item.getQuantity());
    existing.setUnitPrice(item.getUnitPrice());

    return repository.save(existing);
  }


  public void delete(Long id) {
    repository.deleteById(id);
  }

}

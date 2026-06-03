package br.com.program.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.program.application.entities.Order;
import br.com.program.application.repositories.OrderRepository;

@Service
public class OrderService {
  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public Order save(Order order) {
    order.setId(null);
    return repository.save(order);
  }

  public List<Order> findAll() {
    return repository.findAll();
  }

  public Order findById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("pedido não encontrado"));
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

}

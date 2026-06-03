package br.com.program.application.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.program.application.entities.Order;
import br.com.program.application.services.OrderService;

@RestController
@RequestMapping(value = "/pedidos")
public class OrderController {

  private final OrderService service;

  public OrderController(OrderService service) {
    this.service = service;
  }
  
  @GetMapping // busca por todos os pedidos
  public List<Order> list() {
      return service.findAll();
  }

  @GetMapping("/{id}") // busca por um pedido
  public Order findById(@PathVariable Long id) {
      return service.findById(id);
  }

  @DeleteMapping("/{id}") // deleta um pedido
  public void delete(@PathVariable Long id) {
      service.delete(id);
  }

  @PostMapping// salvar um pedido
  public ResponseEntity<Order> create(@RequestBody Order order) {
    Order orderSalvad = service.save(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(orderSalvad);
  }
}
  
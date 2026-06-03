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

import br.com.program.application.entities.OrderItem;
import br.com.program.application.services.OrderItemService;
/*
  Aqui podemos definir aos metodos mapeados para o CRUD
*/
@RestController
@RequestMapping("/itens") // caminho dos recursos
public class OrderItemController {
  private final OrderItemService service;

  public OrderItemController(OrderItemService service) {
    this.service = service;
  }
  
  @GetMapping // busca por todos os itens do pedido
  public List<OrderItem> list() {
      return service.findAll();
  }

  @GetMapping("/{id}") // busca por item do pedido
  public OrderItem findById(@PathVariable Long id) {
      return service.findById(id);
  }

  @PutMapping("/{id}") // atualizar os itens de um pedido
  public OrderItem update(
          @PathVariable Long id,
          @RequestBody OrderItem item) {
      return service.update(id, item);
  }

  @DeleteMapping("/{id}") // deleta um item do pedido
  public void delete(@PathVariable Long id) {
      service.delete(id);
  }

  
  @PostMapping // cria novo item do pedido
  public ResponseEntity<OrderItem> create(@RequestBody OrderItem item) {
    OrderItem orderItemSalvad = service.save(item);
    return ResponseEntity.status(HttpStatus.CREATED).body(orderItemSalvad);
  }

}

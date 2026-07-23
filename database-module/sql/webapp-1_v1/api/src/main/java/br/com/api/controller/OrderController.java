package br.com.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.responseEntity.OrderResponseDTO;
import br.com.api.entities.OrderStatus;
import br.com.api.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

 private final OrderService orderService;

 // resgatar pedido por ID
 @GetMapping("/{orderId}")
 public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long orderId) {
  OrderResponseDTO order = orderService.getOrderById(orderId);
  return ResponseEntity.ok(order);
 }

 // resgatar a lista de todos os pedidos
 @GetMapping
 public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
  List<OrderResponseDTO> list = orderService.findAll();
  return ResponseEntity.ok().body(list);
 }

 // resgatar a lista de pedidos de um cliente específico
 @GetMapping("/user/{userId}")
 public ResponseEntity<List<OrderResponseDTO>> listOrdersByUser(@PathVariable Long userId) {
  return ResponseEntity.ok(orderService.listOrdersByUser(userId));
 }


 // A URL espera o ID do pedido e o número do status, ex: /orders/1/status/2
 /*
  WAITING_PAYMENT(1),
  PAID(2),
  SHIPPED(3),
  DELIVERED(4),
  CANCELED(5);
 */
 @PatchMapping("/{orderId}/status/{statusCode}")
 public ResponseEntity<OrderResponseDTO> updateOrderStatus(
  @PathVariable Long orderId, 
  @PathVariable int statusCode) {
  
  // Converte o código numérico da URL (ex: 2) para o Enum (ex: PAID)
  OrderStatus newStatus = OrderStatus.valueOf(statusCode);
  
  // Passa o ID e o Enum convertido para o service
  OrderResponseDTO updatedOrder = orderService.updateOrderStatus(orderId, newStatus);
   
  return ResponseEntity.ok(updatedOrder);
 }
}

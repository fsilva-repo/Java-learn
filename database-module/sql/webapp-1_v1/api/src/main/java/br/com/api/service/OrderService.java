package br.com.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.dto.responseEntity.OrderResponseDTO;
import br.com.api.dto.responseEntity.summarized.UserSummarizedDTO;
import br.com.api.entities.Order;
import br.com.api.entities.OrderStatus;
import br.com.api.repository.OrderRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class OrderService {
 /* Assim como no UserService foi corrigido o problema de mapeamento manual,
  * aqui também foi feito o mesmo para evitar a exposição de dados sensíveis do usuário e do Hibernate.
  * O DTO OrderResponseDTO substituido por OrderSummarizedDTO agora contém apenas os dados necessários
  * e resumido do cliente, sem expor a senha ou informações internas do Hibernate. 
 */
 private final OrderRepository orderRepository;

 // listar todos os pedidos
 public List<OrderResponseDTO> findAll() {
  List<Order> orders = orderRepository.findAll();
  return orders.stream()
    .map(this::convertToDTO)
    .toList();
 }
 // metodo auxiliar para converter entidade Order para OrderResponseDTO
 private OrderResponseDTO convertToDTO(Order order) {
  // 1. Cria o DTO do cliente omitindo a senha e dados do Hibernate
  UserSummarizedDTO clientDTO = new UserSummarizedDTO(
   order.getClient().getId(),
   order.getClient().getName(),
   order.getClient().getEmail(),
   order.getClient().getPhone());

 // 2. Retorna o DTO do pedido com o cliente
 return new OrderResponseDTO(
   order.getId(),
   order.getOrderDate(),
   order.getLastUpdate(),
   order.getOrderStatus(),
   clientDTO,
   // Retorna o primeiro item do pedido ou null se não houver
   order.getItems().stream().findFirst().orElse(null),
   order.getTotal(),
   order.getItems().stream().findFirst().map(item -> item.getProduct()).orElse(null)
 );
 }


 // buscar pedido por ID
 public OrderResponseDTO getOrderById(Long orderId) {
  Order order = orderRepository.findById(orderId)
   .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " does not exist."));
  return convertToDTO(order);
 }

 // deletar pedido
 public void deleteOrder(Long orderId) {
  if (!orderRepository.existsById(orderId)) {
   throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
  }
  orderRepository.deleteById(orderId);
 }


 // atualizar o status do pedido
 public OrderResponseDTO updateOrderStatus(Long orderId, OrderStatus newStatus) {
  Order order = orderRepository.findById(orderId)
     .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " does not exist."));
  
  order.setOrderStatus(newStatus);
  Order updatedOrder = orderRepository.save(order);
  
  // Retorna o objeto convertido em DTO para o Controller
  return convertToDTO(updatedOrder); 
 }

 
 // recupera a lista de pedidos de um usuario específico
 public List<OrderResponseDTO> listOrdersByUser(Long userId) {
  // 1. Busca as entidades puras do banco de dados
  List<Order> orders = orderRepository.findByClientId(userId);
 
  // 2. Converte as entidades para a estrutura de DTO limpa
  return orders.stream()
   .map(this::convertToDTO)
   .toList();
 }

}

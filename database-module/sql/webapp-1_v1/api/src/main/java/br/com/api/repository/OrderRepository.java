package br.com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
 //List<OrderResponseDTO> findByClient_Id(Long userId);
 List<Order> findByClientId(Long userId);
}

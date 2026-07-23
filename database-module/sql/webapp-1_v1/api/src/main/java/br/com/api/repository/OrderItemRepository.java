package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entities.OrderItem;
import br.com.api.entities.OrderItemCompositeKeys;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemCompositeKeys> {

}

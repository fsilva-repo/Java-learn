package br.com.program.application.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.program.application.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @EntityGraph(attributePaths = {"product", "order"})
    List<OrderItem> findAll();
    
    @EntityGraph(attributePaths = {"product", "order"})
    Optional<OrderItem> findById(Long id);
}

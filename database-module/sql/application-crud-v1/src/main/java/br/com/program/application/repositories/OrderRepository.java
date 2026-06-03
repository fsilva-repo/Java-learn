package br.com.program.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.program.application.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}

package br.com.api.dto.responseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.api.dto.responseEntity.summarized.UserSummarizedDTO;
import br.com.api.entities.OrderItem;
import br.com.api.entities.OrderStatus;
import br.com.api.entities.Product;

public record OrderResponseDTO(
 Long id,
 LocalDateTime orderDate,
 LocalDateTime lastUpdate,
 OrderStatus orderStatus,
 UserSummarizedDTO client,
 OrderItem orderItem,
 BigDecimal total,
 Product product
) {}




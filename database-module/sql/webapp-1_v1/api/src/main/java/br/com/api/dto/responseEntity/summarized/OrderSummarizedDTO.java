package br.com.api.dto.responseEntity.summarized;

import java.time.LocalDateTime;

import br.com.api.entities.OrderStatus;

public record OrderSummarizedDTO(
 Long id,
 LocalDateTime orderDate,
 LocalDateTime lastUpdate,
 OrderStatus orderStatus
) {}

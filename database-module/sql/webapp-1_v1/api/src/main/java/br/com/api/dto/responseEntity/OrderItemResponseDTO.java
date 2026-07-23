package br.com.api.dto.responseEntity;

import java.math.BigDecimal;

import br.com.api.dto.responseEntity.summarized.OrderSummarizedDTO;
import br.com.api.dto.responseEntity.summarized.UserSummarizedDTO;
import br.com.api.entities.OrderItemCompositeKeys;

public record OrderItemResponseDTO(
 OrderItemCompositeKeys id,
 Integer quantity,
 BigDecimal price,
 OrderSummarizedDTO orderSummarizedDTO,
 UserSummarizedDTO userSummarizedDTO
) {}

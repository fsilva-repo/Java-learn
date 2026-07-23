package br.com.api.dto.responseEntity;

import java.math.BigDecimal;
import java.util.Set;

public record ProductResponseDTO(
 Long id,
 String name,
 String description,
 BigDecimal price,
 String imageUrl,
 Set<CategoryResponseDTO> category,
 Set<Long> orders
) {}

package br.com.api.dto.responseEntity;

import java.util.List;

import br.com.api.dto.responseEntity.summarized.OrderSummarizedDTO;

public record UserResponseDTO(
 Long id,
 String name,
 String email,
 String phone,
 List<OrderSummarizedDTO> orders
) {
}
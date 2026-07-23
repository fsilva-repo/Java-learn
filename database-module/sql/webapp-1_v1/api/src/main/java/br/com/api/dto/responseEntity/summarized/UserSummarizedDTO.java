package br.com.api.dto.responseEntity.summarized;

public record UserSummarizedDTO(
 Long id,
 String name,
 String email,
 String phone
) {}

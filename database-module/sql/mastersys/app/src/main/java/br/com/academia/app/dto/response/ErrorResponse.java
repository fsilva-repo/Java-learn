package br.com.academia.app.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(
 LocalDateTime timestamp,
    Integer status,
    String error,
    java.util.List<String> messages,
    String path
) {}

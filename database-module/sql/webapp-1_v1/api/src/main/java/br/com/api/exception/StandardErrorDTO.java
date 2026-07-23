package br.com.api.exception;

import java.time.LocalDateTime;

// Classe StandardErrorDTO representa a estrutura de erro padrão para respostas de exceção na API.
public record StandardErrorDTO (
  LocalDateTime timeStamp,
  Integer status,
  String message,
  String error,
  String path
) {}

package br.com.academia.app.exception;

// trata exceções de nível de serviço, como campos obrigatórios nulos
public class BusinessException extends RuntimeException {
  public BusinessException(String message) {
    super(message);
  }

}

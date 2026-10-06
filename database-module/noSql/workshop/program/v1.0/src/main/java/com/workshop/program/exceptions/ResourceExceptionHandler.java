package com.workshop.program.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice 
public class ResourceExceptionHandler {

  /*
   * esta classe sera usada para manipular erros
   * o objetivo é retornar uma resposta customizada
   * e mais especifica, facilitando o entendimento de
   * porque o erro aconteceu
  */

  // quando o sistema utilizar essa exception
  @ExceptionHandler(ObjectNotFoundException.class)
  // sera retornado essa resposta manipulada/personalizada
  public ResponseEntity<StandardError> objectNotFound(
    ObjectNotFoundException e,
    HttpServletRequest request) {

      HttpStatus status = HttpStatus.NOT_FOUND;
      StandardError error = new StandardError(
        System.currentTimeMillis(), status.value(),
        "Não encontrado",
        e.getMessage(),
      request.getRequestURI());


      return ResponseEntity.status(status).body(error);
    
  }
}

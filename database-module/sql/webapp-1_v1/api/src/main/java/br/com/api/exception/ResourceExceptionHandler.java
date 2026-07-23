package br.com.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

 /* Classe personalizada para o tratamento de exceção onde os recursos não são encontrados */
 @ExceptionHandler(ResourceNotFoundExceptions.class)
 public ResponseEntity<StandardErrorDTO> resourceNotFound(ResourceNotFoundExceptions e, HttpServletRequest request) {
  String error = "Resource not found";
  HttpStatus status = HttpStatus.NOT_FOUND;
  StandardErrorDTO err = new StandardErrorDTO(
   LocalDateTime.now(),
   status.value(),
   error,
   e.getMessage(),
   request.getRequestURI()
  );
  return ResponseEntity.status(status).body(err);
 }



 @ExceptionHandler(DataBaseException.class)
 public ResponseEntity<StandardErrorDTO> database(DataBaseException e, HttpServletRequest request) {
  String error = "Database error: integrity constraint violation";
  HttpStatus status = HttpStatus.BAD_REQUEST;
  StandardErrorDTO err = new StandardErrorDTO(
   LocalDateTime.now(),
   status.value(),
   error,
   e.getMessage(),
   request.getRequestURI()
  );
  return ResponseEntity.status(status).body(err);
 }
}

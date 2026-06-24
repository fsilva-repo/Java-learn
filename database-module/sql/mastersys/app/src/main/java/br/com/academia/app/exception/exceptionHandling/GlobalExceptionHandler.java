package br.com.academia.app.exception.exceptionHandling;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.academia.app.dto.response.ErrorResponse;
import br.com.academia.app.exception.BusinessException;
import br.com.academia.app.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
 

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse>
  handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request)
  {
    List<String> errorMessages = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(error -> error.getField() + ": " + error.getDefaultMessage())
        .toList();
    ErrorResponse errorResponse = new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.BAD_REQUEST.value(),
        "Erro de validação",
        errorMessages,
        request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> 
  serviceHandlingException(BusinessException ex, HttpServletRequest request)
  {
    ErrorResponse errorResponse = new ErrorResponse(
      LocalDateTime.now(),
      HttpStatus.BAD_REQUEST.value(),
      "Campo com valor inválido ou nulo",
      List.of(ex.getMessage()),
      request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> resourceNotFoundHandlingException
  (ResourceNotFoundException ex, HttpServletRequest request)
  {
     ErrorResponse errorResponse = new ErrorResponse(
        LocalDateTime.now(),
        HttpStatus.BAD_REQUEST.value(),
        "Recurso não encontrado",
        List.of(ex.getMessage()),
        request.getRequestURI()
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
public ResponseEntity<ErrorResponse> handleMethodNotAllowed(
        HttpRequestMethodNotSupportedException ex,
        HttpServletRequest request) {

    ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.METHOD_NOT_ALLOWED.value(),
            "Método HTTP não permitido",
            List.of(
                "O método '" + ex.getMethod() + "' não é suportado para este endpoint."
            ),
            request.getRequestURI()
    );

    return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(errorResponse);
  }

  // @ExceptionHandler(IllegalArgumentException.class)
  // public ResponseEntity<ErrorResponse> handleIllegalArgument(
  //       IllegalArgumentException ex) {
  //   ErrorResponse response = new ErrorResponse(
  //           LocalDateTime.now(),
  //           HttpStatus.BAD_REQUEST.value(),
  //           "Argumento inválido",
  //           List.of(ex.getMessage()),
  //           request.getRequestURI()
  //   );

  //   return ResponseEntity.badRequest().body(response);
  // }





  // // Fallback para qualquer erro não tratado
  // @ExceptionHandler(Exception.class)
  // public ResponseEntity<ErrorResponse> handleGeneric(
  //       Exception ex) {

  //   ErrorResponse response = new ErrorResponse(
  //           LocalDateTime.now(),
  //           HttpStatus.INTERNAL_SERVER_ERROR.value(),
  //           "Erro interno do servidor",
  //           List.of("Ocorreu um erro inesperado."),
  //           ""
  //   );

  //   return ResponseEntity.internalServerError()
  //           .body(response);
  // }
}

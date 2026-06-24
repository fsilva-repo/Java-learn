package br.com.academia.app.exception;

import jakarta.persistence.EntityNotFoundException;

/* Se a entidade não foi encontrada no banco de dados antes de executar a operação,
 * essa exception será lançada.
 */
public class ResourceNotFoundException extends EntityNotFoundException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}

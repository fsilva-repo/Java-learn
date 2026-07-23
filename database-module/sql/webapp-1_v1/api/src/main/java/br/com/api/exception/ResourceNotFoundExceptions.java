package br.com.api.exception;

public class ResourceNotFoundExceptions extends RuntimeException {

 /* Classe que utiliza os métodos da classe pai RuntimeException
  * para criar uma exceção personalizada para recursos não encontrados.
 */
 public ResourceNotFoundExceptions(Object id) {
  super("Resource not found with ID: " + id);
 }

}

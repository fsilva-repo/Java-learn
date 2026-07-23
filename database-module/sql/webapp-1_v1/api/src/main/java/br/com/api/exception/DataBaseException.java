package br.com.api.exception;

public class DataBaseException extends RuntimeException {

 /* Classe que utiliza os métodos da classe pai RuntimeException
  * para criar uma exceção personalizada para erros de banco de dados.
 */
 public DataBaseException(String message) {
  super(message);
 }

}

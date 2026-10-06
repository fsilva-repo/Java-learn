package com.workshop.program.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.workshop.program.domain.User;
import com.workshop.program.dto.UserDTO;
import com.workshop.program.exceptions.ObjectNotFoundException;
import com.workshop.program.repository.UserRepository;

@Service 
public class UserService {

  private UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }
  
  public List<User> findUsers() {
    return repository.findAll();
  }
  
  /*
    ## IMPORTANTE ##

    A principal diferença é que retornar User indica que o método sempre retornará uma
    instância válida desse objeto, nunca null.
    Já retornar Optional<User> comunica explicitamente na assinatura do método que o
    resultado pode não existir (estar vazio),
    obrigando o desenvolvedor a lidar com a ausência do valor. 

    Retornar User:
    Implica que o objeto é obrigatório e sempre presente. Se não houver um usuário válido,
    o código tradicionalmente retornaria null (o que pode causar NullPointerException) ou
    lançaria uma exceção.

    Retornar Optional<User>:
    Funciona como uma "caixa" que ou contém um objeto User ou está explicitamente vazia
    (Optional.empty()). Isso torna a API mais segura e declarativa,
    removendo a ambiguidade sobre a possibilidade de retorno nulo. 
  

  
  // minha solucao
  public User findById(String id) {
    List<User> list = repository.findAll();
    User user = null;
    
    for (User u : list) {// evite erros sempre compare string como equals
      if (u.getId().equals(id)) {
        user = u;
      }
    }

    if (user == null) {
      throw new ObjectNotFoundException("Usuario não existe");
    }

    return  user;
  }
 */

  // solucao pronta
  public User findById(String id) {
    return repository.findById(id)
      .orElseThrow(() ->
      new ObjectNotFoundException("Usuario não existe"));
  }

  public User insert(User user) {
    return repository.insert(user);
  }

  // o metodo que devolve um obj User a partir de um obj UserDTO
  // foi implementado aqui poque aqui ja temos uma conexao com o repository
  // facilitando futuras melhorias no sistema
  public User fromDTO(UserDTO userDto) {
    return new User(userDto.getId(), userDto.getName(), userDto.getEmail()); 
  }
}

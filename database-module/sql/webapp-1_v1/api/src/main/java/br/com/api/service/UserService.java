package br.com.api.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.api.dto.responseEntity.UserResponseDTO;
import br.com.api.dto.responseEntity.summarized.OrderSummarizedDTO;
import br.com.api.entities.User;
import br.com.api.exception.DataBaseException;
import br.com.api.exception.ResourceNotFoundExceptions;
import br.com.api.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  /* O UserService foi atualizado para corrigir o problema de mapeamento manual,
   * evitando a exposição de dados sensíveis do usuário e do Hibernate.
   * O DTO UserResponseDTO agora contém apenas os dados necessários e resumidos do usuário,
   * sem expor a senha ou informações internas do Hibernate. 
   * O DTO OrderSummarizedDTO é usado para representar os pedidos do usuário de forma resumida.
   * substituindo o DTO OrderResponseDTO que continha informações detalhadas do pedido.
  */
 private final UserRepository userRepository;

 // confirma se o email já existe no banco de dados ( uso no momento de cadastro de usuário )
 public boolean existsByEmail(String email) {
  return userRepository.existsByEmail(email);
 }

 // resgata o usuário pelo id, caso não exista lança uma exceção
 public UserResponseDTO getUserById(Long id) {
  User user = userRepository.findById(id)
   .orElseThrow(() -> new ResourceNotFoundExceptions(id));
  return convertToDTO(user);
 }


 // resgata todos os usuários do banco de dados
 public List<UserResponseDTO> getAllUsers() {
 
  List<User> users = userRepository.findAll();
  return users.stream()
    .map(this::convertToDTO)
    .toList();
 }
 // Método auxiliar para fazer o mapeamento manual
 private UserResponseDTO convertToDTO(User user) {
   List<OrderSummarizedDTO> orderDTOs = user.getOrders().stream()
      .map(order -> new OrderSummarizedDTO(
        order.getId(),
        order.getOrderDate(),
        order.getLastUpdate(),
        order.getOrderStatus()
      )).toList();
   return new UserResponseDTO(
    user.getId(),
    user.getName(),
    user.getEmail(),
    user.getPhone(),
    orderDTOs);
 }

 // salva um novo usuário no banco de dados, caso o email já exista lança uma exceção
 public User saveUser(User user) {
  if (userRepository.existsByEmail(user.getEmail())) {
   throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists.");
  }
  return userRepository.save(user);
 }



 // atualiza um usuário existente no banco de dados, caso o id não exista lança uma exceção
 public User updateUser(Long id, User updatedUser) {
    User user = userRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundExceptions(id));
    user.setName(updatedUser.getName());
    user.setEmail(updatedUser.getEmail());
    user.setPassword(updatedUser.getPassword());
  return userRepository.save(user);

 }



 // deleta um usuário existente no banco de dados, caso o id não exista lança uma exceção
 public void deleteUser(Long id) {

  try {
   userRepository.deleteById(id);
  } catch (EmptyResultDataAccessException e) {
   throw new ResourceNotFoundExceptions(id);

  } catch (DataIntegrityViolationException e) {
   throw new DataBaseException(e.getMessage());
  }

 }

}

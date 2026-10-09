package com.workshop.program.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.workshop.program.domain.User;
import com.workshop.program.dto.UserDTO;
import com.workshop.program.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value = "/users")
public class UserResources {
  private UserService service;
  
  public UserResources(UserService service) {
    this.service = service;
  }

  @GetMapping  
  public ResponseEntity<List<UserDTO>> findUsers() {
    List<User> list = service.findUsers();
    List<UserDTO> listDto = list.stream()
    .map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  // anotação importante @PathVariable pois o argumento sera passado na propria url
  @GetMapping("/{id}")  
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User user = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
  
  // anotação importante @RequestBody pois o argumento sera passado no corpo da requisição
  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
    User user = service.fromDTO(dto);// tranforma em obj User
    user = service.insert(user);// pega o novo obj User e inseri no BD

    // boas praticas, retornar a url do novo recurso criado no banco de dados
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(user.getId()).toUri();

    // retorna uma resposta vazia com o status 201 e no cabeçalho
    // o endereço do novo recurso criado 
    return ResponseEntity.created(uri).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO dto) {
    User user = service.fromDTO(dto);// pega o dto e tranforma em obj User
    user.setId(id);// o obj em foco tem que ter o id da busca
    user = service.update(user);// atualiza as informações do obj
    ///return ResponseEntity.noContent().build();



    URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(user.getId()).toUri();

    // retorna uma resposta vazia com o status 201 e no cabeçalho
    // o endereço do novo recurso criado 
    return ResponseEntity.created(uri).build();
  }


}








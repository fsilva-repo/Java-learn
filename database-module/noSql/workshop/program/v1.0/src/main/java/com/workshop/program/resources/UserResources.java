package com.workshop.program.resources;

import java.util.List;
import java.util.stream.Collectors;

import com.workshop.program.domain.User;
import com.workshop.program.dto.UserDTO;
import com.workshop.program.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
    List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User user = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
  

}

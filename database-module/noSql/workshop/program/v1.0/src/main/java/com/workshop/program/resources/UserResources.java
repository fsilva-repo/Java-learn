package com.workshop.program.resources;

import java.util.List;
import com.workshop.program.domain.User;
import com.workshop.program.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResources {
  private UserService service;
  
  public UserResources(UserService service) {
    this.service = service;
  }

  @GetMapping  
  public ResponseEntity<List<User>> findUsers() {
    List<User> list = service.findUsers();
    return ResponseEntity.ok().body(list);
  }
}

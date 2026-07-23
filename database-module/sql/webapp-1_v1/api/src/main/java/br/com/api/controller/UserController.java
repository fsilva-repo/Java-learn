package br.com.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.dto.responseEntity.UserResponseDTO;
import br.com.api.entities.User;
import br.com.api.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

 @GetMapping
 public ResponseEntity<List<UserResponseDTO>> findAll() {
  List<UserResponseDTO> allUsers = userService.getAllUsers();
  return ResponseEntity.ok().body(allUsers);
 }

 @GetMapping("/{id}")
 public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    UserResponseDTO user = userService.getUserById(id);
    return ResponseEntity.ok(user);
 }

 @PostMapping
 public ResponseEntity<User> postUser(@RequestBody User user) {
 User saved = userService.saveUser(user);
 URI uri = ServletUriComponentsBuilder
    .fromCurrentRequest()
    .path("/{id}")
    .buildAndExpand(saved.getId())
    .toUri();
  return ResponseEntity.created(uri).body(saved);
 }
 
@PatchMapping("/{id}")
public ResponseEntity<User> updateUser(@Positive @PathVariable Long id,
                                       @RequestBody User user) {

   User updatedUser = userService.updateUser(id, user);
   return ResponseEntity.ok(updatedUser);
}
 
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteUser(@Valid @PathVariable Long id) {
  userService.deleteUser(id);
  return ResponseEntity.noContent().build();
 }
}

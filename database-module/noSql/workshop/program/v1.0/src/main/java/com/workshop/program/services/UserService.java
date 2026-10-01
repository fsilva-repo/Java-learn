package com.workshop.program.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.workshop.program.domain.User;
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
  
}

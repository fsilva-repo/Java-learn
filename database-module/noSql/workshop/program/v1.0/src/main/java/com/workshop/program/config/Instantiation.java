package com.workshop.program.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.program.domain.User;
import com.workshop.program.repository.UserRepository;

// classe seeding
@Configuration 
public class Instantiation implements CommandLineRunner {

  private UserRepository repository;
  
  public Instantiation(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    repository.deleteAll();
    
    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    repository.saveAll(Arrays.asList(maria, alex, bob));
  }

}

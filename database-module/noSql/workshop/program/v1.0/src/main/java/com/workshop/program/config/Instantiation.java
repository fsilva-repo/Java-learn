package com.workshop.program.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.program.domain.Post;
import com.workshop.program.domain.User;
import com.workshop.program.dto.AuthorDTO;
import com.workshop.program.repository.PostRepository;
import com.workshop.program.repository.UserRepository;

// classe seeding
@Configuration
public class Instantiation implements CommandLineRunner {

  private PostRepository postRepo;
  private UserRepository userRepo;

  public Instantiation(UserRepository userRepo, PostRepository postRepo) {
    this.userRepo = userRepo;
    this.postRepo = postRepo;
  }

  @Override
  public void run(String... args) throws Exception {
    LocalDateTime dateTime = LocalDateTime.now();
    userRepo.deleteAll();
    postRepo.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    // salvar primeiro para gerar os IDs
    userRepo.saveAll(Arrays.asList(maria, alex, bob));

    // uma copia dos dados do author sera salvo na coleção post do banco de dados
    Post p1 = new Post(
      null, dateTime, "partiu viagem!", "ferias em Santa Catarina meu sonho", new AuthorDTO(maria));
    Post p2 = new Post(null, dateTime, "saudades", "boas ferias", new AuthorDTO(alex));
    Post p3 = new Post(null, dateTime, "boa viagem!", "ferias meu sonho :)", new AuthorDTO(bob));

    
    postRepo.saveAll(Arrays.asList(p1, p2, p3));
    
  }

}

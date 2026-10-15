package com.workshop.program.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshop.program.domain.Post;
import com.workshop.program.domain.User;
import com.workshop.program.dto.AuthorDTO;
import com.workshop.program.dto.CommentDTO;
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
    Post p10 = new Post(
      null, dateTime, "partiu viagem!", "Amo Santa Catarina", new AuthorDTO(maria));
    
    Post p20 = new Post(null, dateTime, "saude em dia", "Treino pesado!", new AuthorDTO(alex));
    Post p21 = new Post(null, dateTime, "O Treino acabou", "De começar!!", new AuthorDTO(alex));
    Post p22 = new Post(null, dateTime, "Montanbike", "Quem topa trilha", new AuthorDTO(alex));
   
    
    Post p30 = new Post(
      null, dateTime, "Enfim chegaram as ferias", "Muito lazer :)", new AuthorDTO(bob));
    Post p31 = new Post(
      null, dateTime, "Filme", "Filme e pipoca quem resiste", new AuthorDTO(bob));

    CommentDTO c1 = new CommentDTO(LocalDateTime.now(), "estamos junto", new AuthorDTO(bob));
    CommentDTO c2 = new CommentDTO(LocalDateTime.now(), "vamos aproveitar para entrar em forma", new AuthorDTO(alex));
    CommentDTO c3 = new CommentDTO(LocalDateTime.now(), "aproveita bastente saudades", new AuthorDTO(bob));

    

    p22.getComments().addAll(Arrays.asList(c1));
    p30.getComments().addAll(Arrays.asList(c2));
    p10.getComments().addAll(Arrays.asList(c3));


    // Aqui cada post sera salvo no db
    postRepo.saveAll(Arrays.asList(p10, p20, p21, p22, p30, p31));

    maria.getPosts().addAll(Arrays.asList(p10));

    alex.getPosts().addAll(Arrays.asList(p20));
    alex.getPosts().addAll(Arrays.asList(p21));
    alex.getPosts().addAll(Arrays.asList(p22));
    

    bob.getPosts().addAll(Arrays.asList(p30));
    bob.getPosts().addAll(Arrays.asList(p31));

    userRepo.save(maria);
    userRepo.save(alex);
    userRepo.save(bob);

    
  }

}

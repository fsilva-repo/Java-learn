package com.workshop.program.services;

import org.springframework.stereotype.Service;

import com.workshop.program.domain.Post;
import com.workshop.program.exceptions.ObjectNotFoundException;
import com.workshop.program.repository.PostRepository;

@Service
public class PostService {

  private PostRepository repository;

    public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public Post findById(String id) {
    return repository.findById(id)
      .orElseThrow(() ->
      new ObjectNotFoundException("Post não encontrado"));
  }

  
}

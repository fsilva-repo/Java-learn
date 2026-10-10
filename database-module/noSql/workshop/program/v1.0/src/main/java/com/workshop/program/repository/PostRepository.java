package com.workshop.program.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.workshop.program.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {}

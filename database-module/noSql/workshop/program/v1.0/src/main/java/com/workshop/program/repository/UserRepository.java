package com.workshop.program.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.workshop.program.domain.User;

public interface UserRepository extends MongoRepository<User, String> {}

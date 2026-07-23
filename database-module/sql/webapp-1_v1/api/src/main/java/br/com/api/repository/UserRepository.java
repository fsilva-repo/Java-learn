package br.com.api.repository;

import br.com.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
 boolean existsByEmail(String email);
 boolean existsById(Long id);
}

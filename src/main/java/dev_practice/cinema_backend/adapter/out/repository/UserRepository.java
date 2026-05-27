package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import dev_practice.cinema_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Provides database operations for users.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<User> findByUsername(String username);

}

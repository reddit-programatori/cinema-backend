package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Provides database operations for users.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByUsername(String username);

}

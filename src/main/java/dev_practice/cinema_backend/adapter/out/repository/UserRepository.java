package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for users.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for comments.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}

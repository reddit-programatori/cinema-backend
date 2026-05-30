package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for genres.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}

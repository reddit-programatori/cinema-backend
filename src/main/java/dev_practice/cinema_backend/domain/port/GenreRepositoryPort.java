package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.Genre;

import java.util.List;
import java.util.Optional;

/**
 * Defines operations used for managing genres.
 * Allows the application to work with genre data
 * without depending directly on database implementation details.
 */

public interface GenreRepositoryPort {

    Genre save(Genre genre);
    List<Genre> findAll();
    Optional<Genre> findById(long id);
    void deleteById(long id);

}

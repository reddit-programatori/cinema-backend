package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.Movie;

import java.util.List;
import java.util.Optional;

/**
 * Defines operations used for managing movies.
 * Allows the application to work with movie data
 * without depending directly on database implementation details.
 */

public interface MovieRepositoryPort {

    Movie save(Movie movie);
    List<Movie> findAll();
    Optional<Movie> findById(long id);
    void deleteById(long id);

}

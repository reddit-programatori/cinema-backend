package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.exception.NotFoundException;
import dev_practice.cinema_backend.domain.model.Movie;
import dev_practice.cinema_backend.domain.port.MovieRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains business logic related to movies.
 * Acts as the main layer between the API and data storage.
 */

@Service
public class MovieService {

    private final MovieRepositoryPort movieRepositoryPort;

    public MovieService(MovieRepositoryPort movieRepositoryPort) {
        this.movieRepositoryPort = movieRepositoryPort;
    }

    public Movie add(Movie movie) {
        return movieRepositoryPort.save(movie);
    }

    public Movie findById(long id) {
        return movieRepositoryPort.findById(id)
                .orElseThrow(() -> NotFoundException.movie(id));
    }

    public List<Movie> findAll() {
        return movieRepositoryPort.findAll();
    }

    public Movie update(Long id, Movie movie) {
        Movie existing = findById(id);
        existing.setName(movie.getName());
        existing.setDescription(movie.getDescription());
        existing.setDuration(movie.getDuration());
        existing.setRating(movie.getRating());
        return movieRepositoryPort.save(existing);
    }

    public void deleteById(long id) {
        movieRepositoryPort.deleteById(id);
    }
}

package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.entity.MovieEntity;
import dev_practice.cinema_backend.adapter.out.mapper.MovieMapper;
import dev_practice.cinema_backend.adapter.out.repository.MovieRepository;
import dev_practice.cinema_backend.domain.model.Movie;
import dev_practice.cinema_backend.domain.port.MovieRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Connects application movie operations to database access.
 * Handles conversion between domain movie and database entities.
 */

@Component
public class MoviePersistence implements MovieRepositoryPort {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MoviePersistence(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public Movie save(Movie movie) {
        MovieEntity movieEntity = movieRepository.save(movieMapper.toEntity(movie));
        return movieMapper.toDomain(movieEntity);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll()
                .stream()
                .map(movieMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDomain);
    }

    @Override
    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }
}

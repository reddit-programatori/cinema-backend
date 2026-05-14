package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.GenreEntity;
import dev_practice.cinema_backend.adapter.out.entity.MovieEntity;
import dev_practice.cinema_backend.domain.model.Genre;
import dev_practice.cinema_backend.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Converts movie objects between application models
 * and database entities.
 */

@Component
public class MovieMapper {

    private GenreMapper genreMapper;

    public MovieMapper(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    public Movie toDomain(MovieEntity movieEntity) {
        if (movieEntity == null) {
            return null;
        }
        List<Genre> genres = null;
        if (movieEntity.getGenreEntities() != null) {
            genres = movieEntity.getGenreEntities()
                    .stream()
                    .map(genreMapper::toDomain)
                    .toList();
        }
        return new Movie(
                movieEntity.getId(),
                movieEntity.getName(),
                movieEntity.getDescription(),
                movieEntity.getDuration(),
                movieEntity.getRating(),
                null,
                genres
        );
    }

    public MovieEntity toEntity(Movie movie) {
        if (movie == null) {
            return null;
        }
        List<GenreEntity> genreEntities = null;
        if (movie.getGenres() != null) {
            genreEntities = movie.getGenres()
                    .stream()
                    .map(genreMapper::toEntity)
                    .toList();
        }
        return new MovieEntity(
                movie.getId(),
                movie.getName(),
                movie.getDescription(),
                movie.getDuration(),
                movie.getRating(),
                null,
                genreEntities
        );
    }
}

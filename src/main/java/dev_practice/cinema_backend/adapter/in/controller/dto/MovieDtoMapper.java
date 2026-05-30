package dev_practice.cinema_backend.adapter.in.controller.dto;

import dev_practice.cinema_backend.domain.model.Genre;
import dev_practice.cinema_backend.domain.model.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDtoMapper {

    private final GenreDtoMapper genreDtoMapper;

    public MovieDtoMapper(GenreDtoMapper genreDtoMapper) {
        this.genreDtoMapper = genreDtoMapper;
    }

    public Movie toDomain(MovieRequest request) {
        List<Genre> genres = request.getGenreIds() == null ? List.of()
                : request.getGenreIds().stream().map(id -> new Genre(id, null, null)).toList();
        return new Movie(0L, request.getName(), request.getDescription(),
                request.getDuration(), request.getRating(), null, genres);
    }

    public MovieResponse toResponse(Movie movie) {
        List<GenreResponse> genres = movie.getGenres() == null ? List.of()
                : movie.getGenres().stream().map(genreDtoMapper::toResponse).toList();
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDescription(),
                movie.getDuration(), movie.getRating(), genres);
    }
}

package dev_practice.cinema_backend.adapter.in.controller.dto;

import dev_practice.cinema_backend.domain.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreDtoMapper {

    public Genre toDomain(GenreRequest request) {
        return new Genre(0L, request.getName(), null);
    }

    public GenreResponse toResponse(Genre genre) {
        return new GenreResponse(genre.getId(), genre.getName());
    }
}

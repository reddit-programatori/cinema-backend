package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.GenreEntity;
import dev_practice.cinema_backend.domain.model.Genre;
import org.springframework.stereotype.Component;

/**
 * Converts genre objects between application models
 * and database entities.
 */

@Component
public class GenreMapper {

    public Genre toDomain(GenreEntity genreEntity) {
        if (genreEntity == null) {
            return null;
        }
        return new Genre(
                genreEntity.getId(),
                genreEntity.getName(),
                null
        );
    }

    public GenreEntity toEntity(Genre genre) {
        if (genre == null) {
            return null;
        }
        return new GenreEntity(
                genre.getId(),
                genre.getName(),
                null
        );
    }
}

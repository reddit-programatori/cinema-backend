package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.entity.GenreEntity;
import dev_practice.cinema_backend.adapter.out.mapper.GenreMapper;
import dev_practice.cinema_backend.adapter.out.repository.GenreRepository;
import dev_practice.cinema_backend.domain.model.Genre;
import dev_practice.cinema_backend.domain.port.GenreRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Connects application genre operations to database access.
 * Handles conversion between domain genres and database entities.
 */

@Component
public class GenrePersistence implements GenreRepositoryPort {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenrePersistence(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public Genre save(Genre genre) {
        GenreEntity genreEntity = genreRepository.save(genreMapper.toEntity(genre));
        return genreMapper.toDomain(genreEntity);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll()
                .stream()
                .map(genreMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Genre> findById(long id) {
        return genreRepository.findById(id)
                .map(genreMapper::toDomain);
    }

    @Override
    public void deleteById(long id) {
        genreRepository.deleteById(id);
    }
}

package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.exception.NotFoundException;
import dev_practice.cinema_backend.domain.model.Genre;
import dev_practice.cinema_backend.domain.port.GenreRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains business logic related to genres.
 * Acts as the main layer between the API and data storage.
 */

@Service
public class GenreService {

    private final GenreRepositoryPort genreRepositoryPort;

    public GenreService(GenreRepositoryPort genreRepositoryPort) {
        this.genreRepositoryPort = genreRepositoryPort;
    }

    public Genre add(Genre genre) {
        return genreRepositoryPort.save(genre);
    }

    public Genre findById(long id) {
        return genreRepositoryPort.findById(id)
                .orElseThrow(() -> NotFoundException.genre(id));
    }

    public List<Genre> findAll() {
        return genreRepositoryPort.findAll();
    }

    public Genre update(Long id, Genre genre) {
        Genre existing = findById(id);
        existing.setName(genre.getName());
        return genreRepositoryPort.save(existing);
    }

    public void deleteById(long id) {
        genreRepositoryPort.deleteById(id);
    }
}

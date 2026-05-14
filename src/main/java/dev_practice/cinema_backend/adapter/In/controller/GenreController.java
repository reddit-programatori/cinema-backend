package dev_practice.cinema_backend.adapter.In.controller;

import dev_practice.cinema_backend.domain.model.Genre;
import dev_practice.cinema_backend.application.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to genres.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting user data.
 */

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping
    public Genre postGenre(@RequestBody Genre genre) {
        return genreService.add(genre);
    }

    @GetMapping
    public List<Genre> getAll() {
        return genreService.findAll();
    }

    @GetMapping("{id}")
    public Genre getGenre(@PathVariable long id) {
        return genreService.findById(id);
    }

    @PutMapping("{id}")
    public Genre putGenre(@PathVariable long id, @RequestBody Genre genre) {
        return genreService.update(id, genre);
    }

    @DeleteMapping("{id}")
    public void deleteGenre(@PathVariable long id) {
        genreService.deleteById(id);
    }
}

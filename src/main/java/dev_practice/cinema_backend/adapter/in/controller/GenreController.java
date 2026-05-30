package dev_practice.cinema_backend.adapter.in.controller;

import dev_practice.cinema_backend.adapter.in.controller.dto.GenreDtoMapper;
import dev_practice.cinema_backend.adapter.in.controller.dto.GenreRequest;
import dev_practice.cinema_backend.adapter.in.controller.dto.GenreResponse;
import dev_practice.cinema_backend.application.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to genres.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting genre data.
 */

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreDtoMapper genreDtoMapper;

    public GenreController(GenreService genreService, GenreDtoMapper genreDtoMapper) {
        this.genreService = genreService;
        this.genreDtoMapper = genreDtoMapper;
    }

    @PostMapping
    public GenreResponse postGenre(@RequestBody GenreRequest request) {
        return genreDtoMapper.toResponse(genreService.add(genreDtoMapper.toDomain(request)));
    }

    @GetMapping
    public List<GenreResponse> getAll() {
        return genreService.findAll().stream().map(genreDtoMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public GenreResponse getGenre(@PathVariable long id) {
        return genreDtoMapper.toResponse(genreService.findById(id));
    }

    @PutMapping("{id}")
    public GenreResponse putGenre(@PathVariable long id, @RequestBody GenreRequest request) {
        return genreDtoMapper.toResponse(genreService.update(id, genreDtoMapper.toDomain(request)));
    }

    @DeleteMapping("{id}")
    public void deleteGenre(@PathVariable long id) {
        genreService.deleteById(id);
    }
}

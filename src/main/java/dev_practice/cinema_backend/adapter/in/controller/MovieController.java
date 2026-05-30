package dev_practice.cinema_backend.adapter.in.controller;

import dev_practice.cinema_backend.adapter.in.controller.dto.MovieDtoMapper;
import dev_practice.cinema_backend.adapter.in.controller.dto.MovieRequest;
import dev_practice.cinema_backend.adapter.in.controller.dto.MovieResponse;
import dev_practice.cinema_backend.application.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to movies.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting movie data.
 */

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieDtoMapper movieDtoMapper;

    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
    }

    @PostMapping
    public MovieResponse postMovie(@RequestBody MovieRequest request) {
        return movieDtoMapper.toResponse(movieService.add(movieDtoMapper.toDomain(request)));
    }

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.findAll().stream().map(movieDtoMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public MovieResponse getMovie(@PathVariable long id) {
        return movieDtoMapper.toResponse(movieService.findById(id));
    }

    @PutMapping("{id}")
    public MovieResponse putMovie(@PathVariable long id, @RequestBody MovieRequest request) {
        return movieDtoMapper.toResponse(movieService.update(id, movieDtoMapper.toDomain(request)));
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable long id) {
        movieService.deleteById(id);
    }
}

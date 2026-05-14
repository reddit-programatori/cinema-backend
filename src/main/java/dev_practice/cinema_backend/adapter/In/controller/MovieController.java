package dev_practice.cinema_backend.adapter.In.controller;

import dev_practice.cinema_backend.domain.model.Movie;
import dev_practice.cinema_backend.application.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to movies.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting user data.
 */

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie postMovie(@RequestBody Movie movie) {
        return movieService.add(movie);
    }

    @GetMapping
    public List<Movie> getAll() {
        return movieService.findAll();
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable long id) {
        return movieService.findById(id);
    }

    @PutMapping("{id}")
    public Movie putMovie(@PathVariable long id, @RequestBody Movie movie) {
        return movieService.update(id, movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable long id) {
        movieService.deleteById(id);
    }
}

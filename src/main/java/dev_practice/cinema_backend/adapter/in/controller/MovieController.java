package dev_practice.cinema_backend.adapter.in.controller;

import dev_practice.cinema_backend.adapter.in.controller.dto.MovieDtoMapper;
import dev_practice.cinema_backend.adapter.in.controller.dto.MovieRequest;
import dev_practice.cinema_backend.adapter.in.controller.dto.MovieResponse;
import dev_practice.cinema_backend.application.service.MovieService;
import dev_practice.cinema_backend.application.service.ScreeningService;
import dev_practice.cinema_backend.domain.model.Movie;
import dev_practice.cinema_backend.domain.model.Screening;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    private final ScreeningService screeningService;

    public MovieController(MovieService movieService, MovieDtoMapper movieDtoMapper, ScreeningService screeningService) {
        this.movieService = movieService;
        this.movieDtoMapper = movieDtoMapper;
        this.screeningService = screeningService;
    }

    @PostMapping
    public MovieResponse postMovie(@RequestBody MovieRequest request) {
        return movieDtoMapper.toResponse(movieService.add(movieDtoMapper.toDomain(request)), Collections.emptyList());
    }

    @GetMapping
    public List<MovieResponse> getAll() {
        return movieService.findAll()
                .stream()
                .map(movie -> {
                    List<Screening> screenings = screeningService.findByMovieId(movie.getId());
                    return movieDtoMapper.toResponse(movie, screenings);
                })
                .toList();
    }

    @GetMapping("/upcoming")
    public List<MovieResponse> getAllUpcomingMovies() {
        return movieService.findAllUpcomingMovies()
                .stream()
                .map(movie -> {
                    List<Screening> screenings = screeningService.findByMovieId(movie.getId());
                    return movieDtoMapper.toResponse(movie, screenings);
                })
                .toList();
    }

    @GetMapping("/genre/{genre}")
    public List<MovieResponse> getByGenre(@PathVariable String genre) {
        return movieService.findAllByGenreIn(genre)
                .stream()
                .map(movie -> {
                    List<Screening> screenings = screeningService.findByMovieId(movie.getId());
                    return movieDtoMapper.toResponse(movie, screenings);
                })
                .toList();
    }

    @GetMapping("{id}")
    public MovieResponse getMovie(@PathVariable long id) {
        return movieDtoMapper.toResponse(movieService.findById(id), Collections.emptyList());
    }

    @GetMapping("/best")
    public MovieResponse getBestRatedMovie() {
        Movie movie = movieService.findBestRatedMovie();
        List<Screening> screenings = screeningService.findByMovieId(movie.getId());
        return movieDtoMapper.toResponse(movie, screenings);
    }

    @PutMapping("{id}")
    public MovieResponse putMovie(@PathVariable long id, @RequestBody MovieRequest request) {
        return movieDtoMapper.toResponse(movieService
                .update(id, movieDtoMapper.toDomain(request)), Collections.emptyList());
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable long id) {
        movieService.deleteById(id);
    }
}

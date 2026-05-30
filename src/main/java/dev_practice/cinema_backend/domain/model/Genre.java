package dev_practice.cinema_backend.domain.model;

import java.util.List;

/**
 * Represents a genre in the application.
 * Stores basic account information and related comments.
 */

public class Genre {

    private long id;
    private String name;
    List<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Genre(long id, String name, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.movies = movies;
    }
}

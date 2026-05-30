package dev_practice.cinema_backend.domain.model;

import java.time.Duration;
import java.util.List;

/**
 * Represents a movie in the application.
 * Stores basic account information and related comments.
 */

public class Movie {

    private long id;
    private String name;
    private String description;
    private Duration duration;
    private int rating;
    List<Comment> comments;
    List<Genre> genres;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Movie(long id, String name, String description, Duration duration, int rating, List<Comment> comments, List<Genre> genres) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.comments = comments;
        this.genres = genres;
    }
}

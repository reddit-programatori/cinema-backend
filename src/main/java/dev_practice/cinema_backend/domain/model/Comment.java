package dev_practice.cinema_backend.domain.model;

/**
 * Represents a comment in the application.
 * Stores basic account information and related comments.
 */

public class Comment {

    private long id;
    private int rating;
    private String text;
    private User user;
    private Movie movie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Comment(long id, int rating, String text, User user, Movie movie) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.user = user;
        this.movie = movie;
    }
}

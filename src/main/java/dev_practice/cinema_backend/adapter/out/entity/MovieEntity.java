package dev_practice.cinema_backend.adapter.out.entity;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.List;

/**
 * Database representation of a movie.
 * Mapped to the movies table.
 * Has one-to-many relations to comment.
 * Has many-to-many relations to genres.
 */

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private Duration duration;
    private int rating;
    @OneToMany(mappedBy = "movieEntity")
    List<CommentEntity> commentEntities;
    @ManyToMany
    List<GenreEntity> genreEntities;

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

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public List<GenreEntity> getGenreEntities() {
        return genreEntities;
    }

    public void setGenreEntities(List<GenreEntity> genreEntities) {
        this.genreEntities = genreEntities;
    }

    public MovieEntity() {
    }

    public MovieEntity(long id, String name, String description, Duration duration, int rating, List<CommentEntity> commentEntities, List<GenreEntity> genreEntities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.commentEntities = commentEntities;
        this.genreEntities = genreEntities;
    }
}

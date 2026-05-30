package dev_practice.cinema_backend.adapter.out.entity;

import jakarta.persistence.*;

/**
 * Database representation of a comment.
 * Mapped to the comments table.
 * Has many-to-one relations to user.
 * Has many-to-one relations to movie.
 */

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private int rating;
    private String text;
    @ManyToOne
    UserEntity userEntity;
    @ManyToOne
    MovieEntity movieEntity;

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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public MovieEntity getMovieEntity() {
        return movieEntity;
    }

    public void setMovieEntity(MovieEntity movieEntity) {
        this.movieEntity = movieEntity;
    }

    public CommentEntity() {
    }

    public CommentEntity(long id, int rating, String text, UserEntity userEntity, MovieEntity movieEntity) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.userEntity = userEntity;
        this.movieEntity = movieEntity;
    }
}

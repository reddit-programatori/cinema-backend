package dev_practice.cinema_backend.adapter.out.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Database representation of a genre.
 * Mapped to the genres table.
 * Has many-to-many relations to genres.
 */

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @ManyToMany
    List<MovieEntity> movieEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieEntity> getMovieEntities() {
        return movieEntities;
    }

    public void setMovieEntities(List<MovieEntity> movieEntities) {
        this.movieEntities = movieEntities;
    }

    public GenreEntity() {
    }

    public GenreEntity(Long id, String name, List<MovieEntity> movieEntities) {
        this.id = id;
        this.name = name;
        this.movieEntities = movieEntities;
    }
}

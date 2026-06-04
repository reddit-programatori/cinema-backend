package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Provides database operations for movies.
 * Uses Spring Data JPA for standard CRUD functionality.
 */

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

    @Query("""
            SELECT m FROM MovieEntity m
            WHERE EXISTS (SELECT 1 FROM ScreeningEntity s WHERE s.movie = m)
            ORDER BY m.rating DESC, m.id ASC
            LIMIT 1
            """)
    Optional<MovieEntity> findBestRatedMovie();

    @Query("""
            SELECT m FROM MovieEntity m
            WHERE EXISTS (SELECT 1 FROM ScreeningEntity s WHERE s.movie = m)
              AND EXISTS (SELECT 1 FROM m.genreEntities g WHERE g.name = :genre)
            """)
    List<MovieEntity> findAllByGenreEntitiesName(@Param("genre") String genre);

    @Query("""
            SELECT m FROM MovieEntity m
            WHERE EXISTS (
                SELECT 1 FROM ScreeningEntity s
                WHERE s.movie = m
                  AND s.date >= CURRENT_TIMESTAMP
                  AND s.date <= CURRENT_TIMESTAMP + 14 day
            )
            """)
    List<MovieEntity> findAllUpcomingMovies();
}

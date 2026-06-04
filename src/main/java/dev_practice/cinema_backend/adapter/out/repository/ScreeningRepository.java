package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.adapter.out.entity.ScreeningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreeningRepository extends JpaRepository<ScreeningEntity, Long> {

    List<ScreeningEntity> findByMovieId(Long movieId);
}

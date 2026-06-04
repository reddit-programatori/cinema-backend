package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.Screening;

import java.util.List;

public interface ScreeningRepositoryPort {

    List<Screening> findByMovieId(Long movieId);
}

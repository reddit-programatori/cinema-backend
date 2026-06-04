package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.model.Screening;
import dev_practice.cinema_backend.domain.port.ScreeningRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    private final ScreeningRepositoryPort screeningRepositoryPort;

    public ScreeningService(ScreeningRepositoryPort screeningRepositoryPort) {
        this.screeningRepositoryPort = screeningRepositoryPort;
    }

    public List<Screening> findByMovieId(long movieId) {
        return screeningRepositoryPort.findByMovieId(movieId);
    }
}

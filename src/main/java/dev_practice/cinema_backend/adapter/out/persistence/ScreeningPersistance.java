package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.mapper.ScreeningMapper;
import dev_practice.cinema_backend.adapter.out.repository.ScreeningRepository;
import dev_practice.cinema_backend.domain.model.Screening;
import dev_practice.cinema_backend.domain.port.ScreeningRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScreeningPersistance implements ScreeningRepositoryPort {

    private final ScreeningRepository screeningRepository;
    private final ScreeningMapper screeningMapper;

    public ScreeningPersistance(ScreeningRepository screeningRepository, ScreeningMapper screeningMapper) {
        this.screeningRepository = screeningRepository;
        this.screeningMapper = screeningMapper;
    }

    @Override
    public List<Screening> findByMovieId(Long movieId) {
        return screeningRepository.findByMovieId(movieId)
                .stream()
                .map(screeningMapper::toDomain)
                .toList();
    }
}

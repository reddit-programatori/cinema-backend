package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.ScreeningEntity;
import dev_practice.cinema_backend.domain.model.Screening;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapper {

    private final MovieMapper movieMapper;

    public ScreeningMapper(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    public Screening toDomain(ScreeningEntity screeningEntity) {
        if (screeningEntity == null) {
            return null;
        }

        return new Screening(
                screeningEntity.getId(),
                screeningEntity.getCinema(),
                screeningEntity.getDate(),
                movieMapper.toDomain(screeningEntity.getMovie())
        );
    }
}

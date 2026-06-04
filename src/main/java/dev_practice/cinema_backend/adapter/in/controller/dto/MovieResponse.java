package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.util.List;

@Getter
@AllArgsConstructor
public class MovieResponse {

    private long id;
    private String name;
    private String description;
    private Duration duration;
    private int rating;
    private List<GenreResponse> genres;
    private String url;
    private List<ScreeningResponse> screening;
}

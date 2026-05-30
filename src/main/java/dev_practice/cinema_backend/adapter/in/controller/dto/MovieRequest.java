package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
public class MovieRequest {

    private String name;
    private String description;
    private Duration duration;
    private int rating;
    private List<Long> genreIds;
}

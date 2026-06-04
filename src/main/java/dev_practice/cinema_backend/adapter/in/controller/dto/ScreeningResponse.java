package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScreeningResponse {
    private long id;
    private String cinema;
    private String startTime;
}

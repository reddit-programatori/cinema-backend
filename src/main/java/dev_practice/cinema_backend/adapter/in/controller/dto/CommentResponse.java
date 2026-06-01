package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private long id;
    private int rating;
    private String text;
    private String userId;
    private Long movieId;
}

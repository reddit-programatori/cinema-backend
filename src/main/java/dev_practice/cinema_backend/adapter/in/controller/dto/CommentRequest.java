package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

    private int rating;
    private String text;
    private String userId;
    private long movieId;
}

package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

@Getter
@Setter
public class CommentRequest {

    private int rating;
    private String text;
    @UUID
    private String userId;
    private long movieId;
}

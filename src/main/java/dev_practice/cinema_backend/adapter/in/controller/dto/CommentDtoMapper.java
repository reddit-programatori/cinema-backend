package dev_practice.cinema_backend.adapter.in.controller.dto;

import dev_practice.cinema_backend.domain.model.Comment;
import dev_practice.cinema_backend.domain.model.Movie;
import dev_practice.cinema_backend.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentDtoMapper {

    public Comment toDomain(CommentRequest request) {
        User user = new User();
        user.setId(UUID.fromString(request.getUserId()));
        Movie movie = new Movie(request.getMovieId(), null, null, null, 0, null, null);
        return new Comment(0L, request.getRating(), request.getText(), user, movie);
    }

    public CommentResponse toResponse(Comment comment) {
        UUID userId = comment.getUser() == null ? null : comment.getUser().getId();
        Long movieId = comment.getMovie() == null ? null : comment.getMovie().getId();
        return new CommentResponse(comment.getId(), comment.getRating(), comment.getText(), userId.toString(), movieId);
    }
}

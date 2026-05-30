package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.Comment;

import java.util.List;
import java.util.Optional;

/**
 * Defines operations used for managing comments.
 * Allows the application to work with comment data
 * without depending directly on database implementation details.
 */

public interface CommentRepositoryPort {

    Comment save(Comment comment);
    List<Comment> findAll();
    Optional<Comment> findById(long id);
    void deleteById(long id);
}

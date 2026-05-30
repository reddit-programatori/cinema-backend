package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.exception.NotFoundException;
import dev_practice.cinema_backend.domain.model.Comment;
import dev_practice.cinema_backend.domain.port.CommentRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains business logic related to comments.
 * Acts as the main layer between the API and data storage.
 */

@Service
public class CommentService {

    private final CommentRepositoryPort commentRepositoryPort;

    public CommentService(CommentRepositoryPort commentRepositoryPort) {
        this.commentRepositoryPort = commentRepositoryPort;
    }


    public Comment add(Comment comment) {
        return commentRepositoryPort.save(comment);
    }

    public Comment findById(long id) {
        return commentRepositoryPort.findById(id)
                .orElseThrow(() -> NotFoundException.comment(id));
    }

    public List<Comment> findAll() {
        return commentRepositoryPort.findAll();
    }

    public Comment update(Long id, Comment comment) {
        Comment existing = findById(id);
        existing.setText(comment.getText());
        existing.setRating(comment.getRating());
        return commentRepositoryPort.save(existing);
    }

    public void delete(long id) {
        commentRepositoryPort.deleteById(id);
    }
}

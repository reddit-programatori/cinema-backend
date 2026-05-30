package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.entity.CommentEntity;
import dev_practice.cinema_backend.adapter.out.mapper.CommentMapper;
import dev_practice.cinema_backend.adapter.out.repository.CommentRepository;
import dev_practice.cinema_backend.domain.model.Comment;
import dev_practice.cinema_backend.domain.port.CommentRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Connects application comment operations to database access.
 * Handles conversion between domain comments and database entities.
 */

@Component
public class CommentPersistence implements CommentRepositoryPort {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentPersistence(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public Comment save(Comment comment) {
        CommentEntity commentEntity = commentRepository.save(commentMapper.toEntity(comment));
        return commentMapper.toDomain(commentEntity);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Comment> findById(long id) {
        return commentRepository.findById(id)
                .map(commentMapper::toDomain);
    }

    @Override
    public void deleteById(long id) {
        commentRepository.deleteById(id);
    }
}

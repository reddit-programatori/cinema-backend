package dev_practice.cinema_backend.adapter.out.mapper;


import dev_practice.cinema_backend.adapter.out.entity.CommentEntity;
import dev_practice.cinema_backend.domain.model.Comment;
import org.springframework.stereotype.Component;

/**
 * Converts comment objects between application models
 * and database entities.
 */

@Component
public class CommentMapper {

    private final UserMapper userMapper;
    private final MovieMapper movieMapper;

    public CommentMapper(UserMapper userMapper, MovieMapper movieMapper) {
        this.userMapper = userMapper;
        this.movieMapper = movieMapper;
    }

    public Comment toDomain(CommentEntity commentEntity) {
        if (commentEntity == null) {
            return null;
        }
        return new Comment(
                commentEntity.getId(),
                commentEntity.getRating(),
                commentEntity.getText(),
                userMapper.toDomain(commentEntity.getUserEntity()),
                movieMapper.toDomain(commentEntity.getMovieEntity())
        );
    }

    public CommentEntity toEntity(Comment comment) {
        if (comment == null) {
            return null;
        }
        return new CommentEntity(
                comment.getId(),
                comment.getRating(),
                comment.getText(),
                userMapper.toEntity(comment.getUser()),
                movieMapper.toEntity(comment.getMovie())
        );
    }
}

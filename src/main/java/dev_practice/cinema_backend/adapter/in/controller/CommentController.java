package dev_practice.cinema_backend.adapter.in.controller;

import dev_practice.cinema_backend.adapter.in.controller.dto.CommentDtoMapper;
import dev_practice.cinema_backend.adapter.in.controller.dto.CommentRequest;
import dev_practice.cinema_backend.adapter.in.controller.dto.CommentResponse;
import dev_practice.cinema_backend.application.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to comments.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting comment data.
 */

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentDtoMapper commentDtoMapper;

    public CommentController(CommentService commentService, CommentDtoMapper commentDtoMapper) {
        this.commentService = commentService;
        this.commentDtoMapper = commentDtoMapper;
    }

    @PostMapping
    public CommentResponse postComment(@RequestBody CommentRequest request) {
        return commentDtoMapper.toResponse(commentService.add(commentDtoMapper.toDomain(request)));
    }

    @GetMapping
    public List<CommentResponse> getAll() {
        return commentService.findAll().stream().map(commentDtoMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public CommentResponse getComment(@PathVariable long id) {
        return commentDtoMapper.toResponse(commentService.findById(id));
    }

    @PutMapping("{id}")
    public CommentResponse putComment(@PathVariable long id, @RequestBody CommentRequest request) {
        return commentDtoMapper.toResponse(commentService.update(id, commentDtoMapper.toDomain(request)));
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.delete(id);
    }
}

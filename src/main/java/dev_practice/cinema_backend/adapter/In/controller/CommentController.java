package dev_practice.cinema_backend.adapter.In.controller;

import dev_practice.cinema_backend.domain.model.Comment;
import dev_practice.cinema_backend.application.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to comments.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting user data.
 */

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment postComment(@RequestBody Comment comment) {
        return commentService.add(comment);
    }

    @GetMapping
    public List<Comment> getAll() {
        return commentService.findAll();
    }

    @GetMapping("{id}")
    public Comment getComment(@PathVariable long id) {
        return commentService.findById(id);
    }

    @PutMapping("{id}")
    public Comment putComment(@PathVariable long id, @RequestBody Comment comment) {
        return commentService.update(id, comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable long id) {
        commentService.delete(id);
    }
}

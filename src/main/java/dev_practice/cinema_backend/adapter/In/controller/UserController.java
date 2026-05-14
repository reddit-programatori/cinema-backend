package dev_practice.cinema_backend.adapter.In.controller;

import dev_practice.cinema_backend.domain.model.User;
import dev_practice.cinema_backend.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles HTTP requests related to users.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting user data.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @PutMapping("{id}")
    public User putUser(@PathVariable long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}

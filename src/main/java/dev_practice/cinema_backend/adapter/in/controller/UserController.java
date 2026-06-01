package dev_practice.cinema_backend.adapter.in.controller;

import dev_practice.cinema_backend.adapter.in.controller.dto.UserDtoMapper;
import dev_practice.cinema_backend.adapter.in.controller.dto.UserRequest;
import dev_practice.cinema_backend.adapter.in.controller.dto.UserResponse;
import dev_practice.cinema_backend.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Handles HTTP requests related to users.
 * Provides endpoints for creating, retrieving, updating,
 * and deleting user data.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    public UserController(UserService userService, UserDtoMapper userDtoMapper) {
        this.userService = userService;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public UserResponse postUser(@RequestBody UserRequest request) {
        return userDtoMapper.toResponse(userService.add(userDtoMapper.toDomain(request)));
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.findAll().stream().map(userDtoMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable String id) {
        return userDtoMapper.toResponse(userService.findById(UUID.fromString(id)));
    }

    @PutMapping("{id}")
    public UserResponse putUser(@PathVariable String id, @RequestBody UserRequest request) {
        return userDtoMapper.toResponse(userService.update(UUID.fromString(id), userDtoMapper.toDomain(request)));
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(UUID.fromString(id));
    }
}

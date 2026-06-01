package dev_practice.cinema_backend.adapter.in.controller.dto;

import dev_practice.cinema_backend.domain.model.Role;
import dev_practice.cinema_backend.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

    public User toDomain(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public UserResponse toResponse(User user) {
        Set<String> roles = user.getRoles() == null
                ? Set.of()
                : user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());
        return new UserResponse(
                user.getId().toString(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                roles
        );
    }
}

package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.Role;

import java.util.Optional;

public interface RoleRepositoryPort {

    Role save(Role role);
    Optional<Role> findByName(String name);
}

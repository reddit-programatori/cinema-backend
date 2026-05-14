package dev_practice.cinema_backend.domain.port;

import dev_practice.cinema_backend.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Defines operations used for managing users.
 * Allows the application to work with user data
 * without depending directly on database implementation details.
 */

public interface UserRepositoryPort {

    User save(User user);
    List<User> findAll();
    Optional<User> findById(long id);
    void deleteById(long id);
}

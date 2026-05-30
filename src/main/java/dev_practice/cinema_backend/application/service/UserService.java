package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.exception.NotFoundException;
import dev_practice.cinema_backend.domain.model.User;
import dev_practice.cinema_backend.domain.port.PasswordHasher;
import dev_practice.cinema_backend.domain.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Contains business logic related to users.
 * Acts as the main layer between the API and data storage.
 */

@Service
public class UserService {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordHasher passwordHasher;

    public UserService(UserRepositoryPort userRepositoryPort, PasswordHasher passwordHasher) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordHasher = passwordHasher;
    }

    public User add(User user) {
        user.setPassword(passwordHasher.hash(user.getPassword()));
        return userRepositoryPort.save(user);
    }

    public User findById(long id) {
        return userRepositoryPort.findById(id)
            .orElseThrow(() -> NotFoundException.user(id));
    }

    public Optional<User> findByUsername(String username) {
        return userRepositoryPort.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setName(user.getName());
        existing.setLastname(user.getLastname());
        existing.setEmail(user.getEmail());
        return userRepositoryPort.save(existing);
    }

    public void delete(long id) {
        userRepositoryPort.deleteById(id);
    }
}

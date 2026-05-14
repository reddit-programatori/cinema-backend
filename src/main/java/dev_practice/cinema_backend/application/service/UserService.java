package dev_practice.cinema_backend.application.service;

import dev_practice.cinema_backend.domain.exception.NotFoundException;
import dev_practice.cinema_backend.domain.model.User;
import dev_practice.cinema_backend.domain.port.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Contains business logic related to users.
 * Acts as the main layer between the API and data storage.
 */

@Service
public class UserService {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    public User add(User user) {
        return userRepositoryPort.save(user);
    }

    public User findById(long id) {
        return userRepositoryPort.findById(id)
            .orElseThrow(() -> NotFoundException.user(id));
    }

    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    public User update(Long id, User user) {
        User existing = findById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        return userRepositoryPort.save(existing);
    }

    public void delete(long id) {
        userRepositoryPort.deleteById(id);
    }
}

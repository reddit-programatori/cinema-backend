package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import dev_practice.cinema_backend.adapter.out.mapper.UserMapper;
import dev_practice.cinema_backend.adapter.out.repository.UserRepository;
import dev_practice.cinema_backend.domain.model.User;
import dev_practice.cinema_backend.domain.port.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Connects application user operations to database access.
 * Handles conversion between domain models and database entities.
 */

@Component
public class UserPersistence implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserPersistence(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(user));
        return userMapper.toDomain(userEntity);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id)
                .map(userMapper::toDomain);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}

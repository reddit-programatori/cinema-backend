package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import dev_practice.cinema_backend.domain.model.User;
import org.springframework.stereotype.Component;

/**
 * Converts user objects between application models
 * and database entities.
 */

@Component
public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                null
        );
    }

    public UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                null
        );

    }
}

package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.RoleEntity;
import dev_practice.cinema_backend.adapter.out.entity.UserEntity;
import dev_practice.cinema_backend.domain.model.Role;
import dev_practice.cinema_backend.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Converts user objects between application models
 * and database entities.
 */

@Component
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public User toDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        Set<Role> roles = userEntity.getRoles() == null
                ? new HashSet<>()
                : userEntity.getRoles().stream().map(roleMapper::toDomain).collect(Collectors.toSet());
        return new User(
                userEntity.getId() == null ? 0L : userEntity.getId(),
                userEntity.getName(),
                userEntity.getLastname(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                roles
        );
    }

    public UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }
        Set<RoleEntity> roles = user.getRoles() == null
                ? new HashSet<>()
                : user.getRoles().stream().map(roleMapper::toEntity).collect(Collectors.toSet());
        return new UserEntity(
                user.getId() == 0L ? null : user.getId(),
                user.getName(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                roles
        );
    }
}

package dev_practice.cinema_backend.adapter.out.mapper;

import dev_practice.cinema_backend.adapter.out.entity.RoleEntity;
import dev_practice.cinema_backend.domain.model.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role toDomain(RoleEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Role(entity.getId(), entity.getName());
    }

    public RoleEntity toEntity(Role role) {
        if (role == null) {
            return null;
        }
        return new RoleEntity(role.getId(), role.getName());
    }
}

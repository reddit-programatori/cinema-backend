package dev_practice.cinema_backend.adapter.out.persistence;

import dev_practice.cinema_backend.adapter.out.entity.RoleEntity;
import dev_practice.cinema_backend.adapter.out.mapper.RoleMapper;
import dev_practice.cinema_backend.adapter.out.repository.RoleRepository;
import dev_practice.cinema_backend.domain.model.Role;
import dev_practice.cinema_backend.domain.port.RoleRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RolePersistence implements RoleRepositoryPort {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RolePersistence(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public Role save(Role role) {
        RoleEntity saved = roleRepository.save(roleMapper.toEntity(role));
        return roleMapper.toDomain(saved);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name).map(roleMapper::toDomain);
    }
}

package dev_practice.cinema_backend.adapter.out.repository;

import dev_practice.cinema_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(String admin);
}

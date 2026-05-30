package dev_practice.cinema_backend.adapter.out.bootstrap;

import dev_practice.cinema_backend.application.service.UserService;
import dev_practice.cinema_backend.domain.model.Role;
import dev_practice.cinema_backend.domain.model.User;
import dev_practice.cinema_backend.domain.port.RoleRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    CommandLineRunner seedData(UserService userService, RoleRepositoryPort roleRepositoryPort) {
        return args -> {
            if (userService.findByUsername("AdminRajan").isPresent()) {
                return;
            }

            Role adminRole = roleRepositoryPort.findByName("Admin")
                    .orElseGet(() -> roleRepositoryPort.save(new Role(0, "Admin")));

            User user = new User();
            user.setName("Rajan");
            user.setLastname("Test");
            user.setUsername("AdminRajan");
            user.setPassword("Admin123");
            user.setRoles(Set.of(adminRole));

            userService.add(user);
            logger.info("Admin user seeded: {}", user.getUsername());
        };
    }
}

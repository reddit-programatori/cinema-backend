package dev_practice.cinema_backend.config;

import dev_practice.cinema_backend.model.Role;
import dev_practice.cinema_backend.model.User;
import dev_practice.cinema_backend.adapter.out.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner seedData(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
                if (userRepository.count() == 0){
                    Role role = roleRepository.findByName("Admin").orElseGet(() -> roleRepository.save(Role.builder().name("Admin").build()));

                    User user = User.builder()
                            .name("Rajan")
                            .lastname("Test")
                            .username("AdminRajan")
                            .password(passwordEncoder.encode("Admin123"))
                            .roles(Set.of(role))
                            .build();
                    userRepository.save(user);
                    logger.info("User created: {}", user);
                }

        };
    }
}
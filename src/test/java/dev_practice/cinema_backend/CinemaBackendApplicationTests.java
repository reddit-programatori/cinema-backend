package dev_practice.cinema_backend;

import dev_practice.cinema_backend.model.User;
import dev_practice.cinema_backend.adapter.out.repository.RoleRepository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Import(TestcontainersConfiguration.class)
class CinemaBackendApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	private static final Logger logger = LoggerFactory.getLogger(CinemaBackendApplicationTests.class);

	@Test
	@Rollback(value = false)
	void createUser(){
		User user = User.builder()
				.name("Admin")
				.lastname("Test")
				.password("Admin123").build();
		userRepository.save(user);
		logger.info("User: {}", user);
	}
}

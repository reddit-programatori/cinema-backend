package dev_practice.cinema_backend.domain.port;

public interface PasswordHasher {

    String hash(String rawPassword);
}

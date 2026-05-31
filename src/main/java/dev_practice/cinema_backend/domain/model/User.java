package dev_practice.cinema_backend.domain.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a user in the application.
 * Stores basic account information and roles.
 */

public class User {

    private UUID id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(UUID id, String name, String lastname, String username, String email, String password,
                Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles != null ? roles : new HashSet<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

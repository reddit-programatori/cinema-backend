package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class UserResponse {

    private long id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private Set<String> roles;
}

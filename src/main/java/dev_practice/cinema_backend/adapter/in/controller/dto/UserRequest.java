package dev_practice.cinema_backend.adapter.in.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
}

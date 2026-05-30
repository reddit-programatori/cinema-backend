package dev_practice.cinema_backend.adapter.in.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponse {

    private String username;
    private String jwt;
}

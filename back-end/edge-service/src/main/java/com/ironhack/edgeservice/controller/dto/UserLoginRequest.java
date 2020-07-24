package com.ironhack.edgeservice.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserLoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
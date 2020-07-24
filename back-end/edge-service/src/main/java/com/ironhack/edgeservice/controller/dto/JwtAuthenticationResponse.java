package com.ironhack.edgeservice.controller.dto;


import com.ironhack.edgeservice.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String username;
    private UserRole userRole;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}

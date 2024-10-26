package com.bgnc.personalfinancemanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthRequest {

    @NotEmpty(message = "username not empty")
    private String username;
    @NotEmpty(message = "password not empty")
    private String password;
}

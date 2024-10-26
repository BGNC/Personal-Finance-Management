package com.bgnc.personalfinancemanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse extends ResponseEntity {

    private String username;
    private String password;

}

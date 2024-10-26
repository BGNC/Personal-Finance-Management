package com.bgnc.personalfinancemanagement.controller;

import com.bgnc.personalfinancemanagement.dto.AuthRequest;
import com.bgnc.personalfinancemanagement.dto.AuthResponse;

public interface IAuthenticationController {
    RootEntity<AuthResponse> register(AuthRequest authRequest);
    RootEntity<AuthResponse> authenticate(AuthRequest authRequest);
}

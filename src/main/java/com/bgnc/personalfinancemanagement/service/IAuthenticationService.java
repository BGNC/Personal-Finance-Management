package com.bgnc.personalfinancemanagement.service;

import com.bgnc.personalfinancemanagement.controller.RootEntity;
import com.bgnc.personalfinancemanagement.dto.AuthRequest;
import com.bgnc.personalfinancemanagement.dto.AuthResponse;

public interface IAuthenticationService {
    AuthResponse register(AuthRequest authRequest);
    AuthResponse authenticate(AuthRequest authRequest);
}

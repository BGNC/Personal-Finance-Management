package com.bgnc.personalfinancemanagement.service.impl;

import com.bgnc.personalfinancemanagement.dto.AuthRequest;
import com.bgnc.personalfinancemanagement.dto.AuthResponse;
import com.bgnc.personalfinancemanagement.jwt.JWTService;
import com.bgnc.personalfinancemanagement.model.User;
import com.bgnc.personalfinancemanagement.repository.UserRepository;
import com.bgnc.personalfinancemanagement.service.IAuthenticationService;
import com.bgnc.personalfinancemanagement.util.LocalDateToDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;

    private User createUser(AuthRequest authRequest){
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setCreateTime(new Date());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));

        return user;

    }

    @Override
    public AuthResponse register(AuthRequest authRequest) {
        User savedUser = userRepository.save(createUser(authRequest));
        return null;

    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        return null;
    }
}

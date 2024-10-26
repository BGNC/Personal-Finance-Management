package com.bgnc.personalfinancemanagement.controller.impl;

import com.bgnc.personalfinancemanagement.controller.IAuthenticationController;
import com.bgnc.personalfinancemanagement.controller.RestBaseController;
import com.bgnc.personalfinancemanagement.controller.RootEntity;
import com.bgnc.personalfinancemanagement.dto.AuthRequest;
import com.bgnc.personalfinancemanagement.dto.AuthResponse;
import com.bgnc.personalfinancemanagement.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl extends RestBaseController implements IAuthenticationController {

    private final IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<AuthResponse> register(AuthRequest authRequest) {
        return ok(authenticationService.register(authRequest));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest) {
        return ok(authenticationService.authenticate(authRequest));
    }
}

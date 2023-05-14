package com.recap.carrental.core.webApi.controllers;

import com.recap.carrental.core.business.abstracts.AuthService;
import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/auth/")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public String register(@RequestBody AuthRegisterRequest request) {
        return this.authService.register(request);
    }

    @PostMapping(value = "/authenticate")
    public String authenticate(@RequestBody AuthLoginRequest request) {
        return this.authService.authenticate(request);
    }
}

package com.recap.carrental.core.webApi.controllers;

import com.recap.carrental.core.business.abstracts.AuthService;
import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;
import com.recap.carrental.core.business.responses.authResponses.AuthenticationResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication")
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
    public AuthenticationResponse authenticate(@RequestBody AuthLoginRequest request) {
        return this.authService.authenticate(request);
    }

    @PostMapping(value = "/refresh-token")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        this.authService.refreshToken(request, response);
    }
}

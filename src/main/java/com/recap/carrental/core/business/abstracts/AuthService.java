package com.recap.carrental.core.business.abstracts;

import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;
import com.recap.carrental.core.business.responses.authResponses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    String register(AuthRegisterRequest request);
    AuthenticationResponse authenticate(AuthLoginRequest request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}

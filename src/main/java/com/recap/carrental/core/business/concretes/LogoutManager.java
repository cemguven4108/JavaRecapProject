package com.recap.carrental.core.business.concretes;

import com.recap.carrental.core.business.abstracts.LogoutService;
import com.recap.carrental.core.business.abstracts.TokenService;
import com.recap.carrental.core.entities.Token;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutManager implements LogoutService {

    private final TokenService tokenService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        Token token = this.tokenService.getByToken(jwt);
        token.setExpired(true);
        token.setRevoked(true);
        this.tokenService.create(token);
        SecurityContextHolder.clearContext();
    }
}

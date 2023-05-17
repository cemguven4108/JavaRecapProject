package com.recap.carrental.core.business.concretes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recap.carrental.core.business.abstracts.AuthService;
import com.recap.carrental.core.business.abstracts.JwtService;
import com.recap.carrental.core.business.abstracts.TokenService;
import com.recap.carrental.core.business.abstracts.UserService;
import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;
import com.recap.carrental.core.business.responses.authResponses.AuthenticationResponse;
import com.recap.carrental.core.entities.Token;
import com.recap.carrental.core.entities.User;
import com.recap.carrental.core.entities.enums.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final TokenService tokenService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String register(AuthRegisterRequest request) {
        this.passwordEncoder.encode(request.password());
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.username())
                .password(this.passwordEncoder.encode(request.password()))
                .role(request.role())
                .build();
        this.userService.create(user);
        return "Success";
    }

    @Override
    public AuthenticationResponse authenticate(AuthLoginRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = this.userService.getByEmail(request.username());
        String token = this.jwtService.generateToken(user);
        String refreshToken = this.jwtService.generateRefreshToken(user);

        this.revokeAllUserTokens(user.getId());
        this.saveUserToken(user, token);

        return new AuthenticationResponse(
                token,
                refreshToken
        );
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        username = this.jwtService.extractUsername(refreshToken);
        if (username != null) {
            User user = this.userService.getByEmail(username);
            if (this.jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = this.jwtService.generateToken(user);
                revokeAllUserTokens(user.getId());
                saveUserToken(user, accessToken);
                AuthenticationResponse authResponse = new AuthenticationResponse(
                        accessToken,
                        refreshToken
                );

                try {
                    new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void saveUserToken(User user, String token) {
        Token tokenToSave = Token.builder()
                .token(token)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .user(user)
                .build();
        this.tokenService.create(tokenToSave);
    }

    private void revokeAllUserTokens(int userId) {
        List<Token> validUserTokens = this.tokenService.getAllValidTokenById(userId);
        if (validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(token -> {
            token.setRevoked(true);
            token.setExpired(true);
        });
        this.tokenService.updateAll(validUserTokens);
    }
}

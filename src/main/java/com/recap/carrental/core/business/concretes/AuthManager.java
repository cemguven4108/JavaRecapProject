package com.recap.carrental.core.business.concretes;

import com.recap.carrental.core.business.abstracts.AuthService;
import com.recap.carrental.core.business.abstracts.JwtService;
import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;
import com.recap.carrental.core.dataAccess.UserRepository;
import com.recap.carrental.core.entities.Role;
import com.recap.carrental.core.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final UserRepository userRepository;
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
                .role(Role.USER)
                .build();
        this.userRepository.save(user);
        return "Success";
    }

    @Override
    public String authenticate(AuthLoginRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        User user = this.userRepository.findUserByEmail(request.username());
        return this.jwtService.generateToken(user);
    }
}

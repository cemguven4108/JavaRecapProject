package com.recap.carrental.core.business.abstracts;

import com.recap.carrental.core.business.requests.authRequests.AuthLoginRequest;
import com.recap.carrental.core.business.requests.authRequests.AuthRegisterRequest;

public interface AuthService {
    String register(AuthRegisterRequest request);
    String authenticate(AuthLoginRequest request);
}

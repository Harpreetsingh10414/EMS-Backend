package com.ems.auth.service;

import com.ems.auth.dto.AuthResponse;
import com.ems.auth.dto.LoginRequest;
import com.ems.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);

    void register(RegisterRequest request);
}

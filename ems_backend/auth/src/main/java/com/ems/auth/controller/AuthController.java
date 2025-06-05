package com.ems.auth.controller;

import com.ems.auth.dto.LoginRequest;
import com.ems.auth.dto.RegisterRequest;
import com.ems.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // ✅ Register endpoint
    // http://localhost:8080/api/auth/register
    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Or HttpStatus.OK
    }

    // ✅ Login endpoint
    /*//http://localhost:8080/api/auth/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticateEmployee(@RequestBody LoginRequest loginRequest) {
        AuthResponse authResponse = authService.login(loginRequest);
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }*/

    //http://localhost:8080/api/auth/dummyLogin
    @PostMapping("/dummyLogin")
    public ResponseEntity<String> authenticateEmployee(@RequestBody LoginRequest loginRequest) {
        System.out.println("dummy login is working ");
        String message = authService.login1(loginRequest);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

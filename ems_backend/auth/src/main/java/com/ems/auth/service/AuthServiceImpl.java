package com.ems.auth.service;

import com.ems.auth.client.EmployeeClient;
import com.ems.auth.dto.AuthResponse;
import com.ems.auth.dto.EmployeeDto;
import com.ems.auth.dto.LoginRequest;
import com.ems.auth.dto.RegisterRequest;
import com.ems.auth.model.AuthUser;
import com.ems.auth.repository.AuthUserRepository;
import com.ems.auth.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private static final String default_password = "otw@123";


    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmployeeClient employeeClient;

    @Autowired
    public AuthServiceImpl(AuthUserRepository authUserRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, EmployeeClient employeeClient) {
        this.authUserRepository = authUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.employeeClient = employeeClient;
    }

    @Override
    public void register(RegisterRequest request) {
        EmployeeDto emp = employeeClient.getEmployeeByEmail(request.getEmail());
        if (emp==null){
            throw new RuntimeException("Employee not found");
        } else if (emp.isRegistered()) {
            throw new RuntimeException("Employee already registered");
        }

        // Check if email already exists in authorization
        if (authUserRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered");
        }
        // Create new employee and save
        AuthUser authUser = AuthUser.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(default_password))
                .role(request.getRole()) // Ensure correct enum mapping
                .active(true)
                .build();

        authUserRepository.save(authUser);
        employeeClient.markEmployeeRegistered(request.getEmail());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        // Authenticate credentials
        try {
            // Try authenticating credentials
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException ex) {
            throw new RuntimeException("Invalid email or password");
        }

        // Fetch employee and generate token
        AuthUser authUser = authUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        System.out.println(authUser);
        String token = jwtService.generateToken(authUser);
        return new AuthResponse(token,"Login successfully");
    }
}

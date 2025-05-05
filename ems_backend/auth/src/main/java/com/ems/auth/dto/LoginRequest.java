package com.ems.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String email;
    private String password;

    // Default constructor
    public LoginRequest() {}

    // Parameterized constructor (if needed)
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

}

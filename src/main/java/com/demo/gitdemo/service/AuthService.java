package com.demo.gitdemo.service;

import com.demo.gitdemo.dto.AuthRequest;
import com.demo.gitdemo.dto.AuthResponse;
import com.demo.gitdemo.security.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse authenticate(AuthRequest request) {
        // Hardcoded username/password
        if ("admin".equals(request.getUsername()) && "admin123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername());
            return new AuthResponse(token);
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }
}

package com.demo.gitdemo.controller;

import com.demo.gitdemo.dto.AuthRequest;
import com.demo.gitdemo.dto.AuthResponse;
import com.demo.gitdemo.dto.ResponseStructure;
import com.demo.gitdemo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseStructure<AuthResponse>> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.authenticate(request);
        return new ResponseEntity<>(
                new ResponseStructure<>(200, "Login Successful", response),
                HttpStatus.OK
        );
    }

}

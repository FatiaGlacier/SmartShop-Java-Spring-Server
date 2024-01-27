package com.fatianov.SmartShop.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register-admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerAdmin(request));
    }

    @PostMapping("/register-employee")
    public ResponseEntity<AuthenticationResponse> registerEmployee(
            @RequestBody RegisterRequest request,
            @RequestHeader (name = HttpHeaders.AUTHORIZATION) String token
    ) throws Exception {
        System.out.println(token);
        return ResponseEntity.ok(service.registerEmployee(token, request));
    }
    @PostMapping("/register-user")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerUser(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}

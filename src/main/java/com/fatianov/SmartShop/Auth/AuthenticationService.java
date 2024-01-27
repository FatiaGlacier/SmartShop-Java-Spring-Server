package com.fatianov.SmartShop.Auth;

import com.fatianov.SmartShop.Entities.Role;
import com.fatianov.SmartShop.Entities.User;
import com.fatianov.SmartShop.Repositories.UserRepository;
import com.fatianov.SmartShop.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    protected User buildUserWithRole(RegisterRequest request, Role role) {
        var user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birthday(request.getBirthday())
                .phone(request.getPhone())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();

        return user;
    }


    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var user = buildUserWithRole(request, Role.ADMIN);

        repository.saveAndFlush(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerEmployee(String jwt, RegisterRequest request) throws Exception {
        final String token = jwt.substring(7);
        String username = jwtService.extractUsername(token);
        User foundUser = repository.findByEmail(username).orElseThrow();

        if(!(jwtService.isAdmin(token, foundUser))){
            throw new Exception("");//TODO custom exception
        }

        var user = buildUserWithRole(request, Role.EMPLOYEE);

        repository.saveAndFlush(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerUser(RegisterRequest request) {
        var user = buildUserWithRole(request, Role.USER);

        repository.saveAndFlush(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}

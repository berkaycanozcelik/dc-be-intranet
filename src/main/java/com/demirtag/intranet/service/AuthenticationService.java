package com.demirtag.intranet.service;

import com.demirtag.intranet.config.JwtService;
import com.demirtag.intranet.model.*;
import com.demirtag.intranet.repository.UserRepository;
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


    public RegisterResponse register(RegisterRequest registerRequest) {
        User registeredUser = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .role(registerRequest.getRole())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        UserDetail registeredUserDetail = UserDetail.builder()
                .address(registerRequest.getAddress())
                .phoneNumber(registerRequest.getPhoneNumber())
                .birthday(registerRequest.getBirthday())
                .title(registerRequest.getTitle())
                .manager(registerRequest.getManager())
                .team(registerRequest.getTeam())
                .build();

        registeredUser.setUserDetail(registeredUserDetail);
        registeredUserDetail.setUser(registeredUser);

        repository.save(registeredUser);

        var jwtToken = jwtService.generateToken(registeredUser);
        return RegisterResponse.builder()
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
        var expirationDate = Long.toString(jwtService.getExpirationDateFromToken(jwtToken));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .id(user.getId())
                .expirationDate(expirationDate)
                .build();
    }
}

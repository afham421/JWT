package com.jwt.services;

import com.jwt.Controoler.AuthenticationRequest;
import com.jwt.Controoler.AuthenticationResponse;
import com.jwt.Controoler.RegisterRequest;
import com.jwt.Repository.RegiserDao;
import com.jwt.configuration.JwtService;
import com.jwt.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceimpl {

    @Autowired
    private RegiserDao regiserDao;
    @Autowired
    public PasswordEncoder passwordEncoder;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        regiserDao.save(user);
//		log.debug(" pass : " +request.getPass().toString());

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = regiserDao.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}

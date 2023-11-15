package com.jwt.Controoler;

import com.jwt.services.RegisterServiceimpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class RegisterController {


    @Autowired
    private RegisterServiceimpl registerServiceimpl;



    @PostMapping("/register")
    private ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){


        return ResponseEntity.ok(registerServiceimpl.register(request));
    }
    @PostMapping("/auth")
    private ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        ResponseEntity<AuthenticationResponse> ok = ResponseEntity.ok(registerServiceimpl.authenticate(request));
        return ok;
    }
}

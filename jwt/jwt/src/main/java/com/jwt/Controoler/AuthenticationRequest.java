package com.jwt.Controoler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jwt.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationRequest {
    private String email;
    private String password;
    private Role role;
}

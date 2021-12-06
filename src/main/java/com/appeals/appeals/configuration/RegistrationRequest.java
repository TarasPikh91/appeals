package com.appeals.appeals.configuration;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    private final String fullUsername;
    private final String username;
    private final String email;
    private final String password;
    private final String phone;
}

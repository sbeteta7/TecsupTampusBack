package com.tampusdev.tampus.controller.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationRequest{
    private String email;
    private String password;

}

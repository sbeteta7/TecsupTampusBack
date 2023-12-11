package com.tampusdev.tampus.controller.models;

import lombok.*;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate fecha_nacimiento;
    private String telefono;

    public RegisterRequest(String firstName, String lastName, String email, String password, String fecha_nacimiento, String telefono) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = LocalDate.parse(fecha_nacimiento);
        this.telefono = telefono;
    }

}

package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.enums.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String firstName;
    private String lastName;

    private String email;

    private String password;

    private String role;
}

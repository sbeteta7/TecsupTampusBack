package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.enums.RoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date fecha_nacimiento;
    private String telefono;


}

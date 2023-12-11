package com.tampusdev.tampus.persistence.DTO;


import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.tampusdev.tampus.persistence.entities.Usuario}
 */
@Value
public class UsuarioDto implements Serializable {
    String firstName;
    String lastName;
    String email;
    String telefono;
}
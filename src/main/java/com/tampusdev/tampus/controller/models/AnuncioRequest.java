package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioRequest {
    private Integer id_user;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private BigDecimal precio;

    private String tipo_espacio;
    private int num_hab;
    private int num_cam;
    private int dimensiones;

}

package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioResponse {
    private int id_anuncio;
    private int id_user;
    private String titulo;
    private String descripcion;
    private String ubicacion;
    private BigDecimal precio;


    private String tipo_espacio;

    private Integer num_hab;
    private Integer num_cama;
    private int dimensiones;

   // private LocalDate fecha_creacion;
}

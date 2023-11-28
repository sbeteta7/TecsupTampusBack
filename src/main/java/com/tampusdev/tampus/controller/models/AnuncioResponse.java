package com.tampusdev.tampus.controller.models;

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
    private String titulo;
    private String descripcion;
    private BigDecimal precio_min;
    private BigDecimal precio_max;

    private String tipo_espacio;

    private Integer num_hab;
    private Integer num_cam;
    private int dimensiones;

   // private LocalDate fecha_creacion;
}

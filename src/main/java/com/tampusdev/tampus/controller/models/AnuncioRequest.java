package com.tampusdev.tampus.controller.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AnuncioRequest {
    private String titulo;
    private String descripcion;
    private BigDecimal precio_min;
    private BigDecimal precio_max;
    private String tipo_espacio;
    private int num_hab;
    private int num_cam;
    private int dimensiones;
}

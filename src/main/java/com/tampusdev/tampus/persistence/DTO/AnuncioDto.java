package com.tampusdev.tampus.persistence.DTO;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.tampusdev.tampus.persistence.entities.Anuncio}
 */
@Value
public class AnuncioDto implements Serializable {
    Integer id_anuncio;
    Integer id_usuario;
    String nombre_anfitrion;
    String proposito;
    String titulo;
    String descripcion;
    String ubicacion;
    BigDecimal precio;
    String tipo_espacio;
    int num_hab;
    int num_cama;
    int dimensiones;
    char estado_anuncio;
}
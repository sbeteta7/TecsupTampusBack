package com.tampusdev.tampus.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_anuncio;
    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private Usuario id_user;
    @Column(length = 50)
    private String proposito;
    @Column(length = 30)
    private String titulo;
    @Column(length = 100)
    private String descripcion;
    @Column(length = 50)
    private String ubicacion;

    private BigDecimal precio;


    @Column(length = 30)
    private String tipo_espacio;
    private int num_hab;
    private int num_cama;
    private int dimensiones;
    @Column(length = 1)
    private char estado_anuncio;
    private LocalDate fecha_creacion;




}


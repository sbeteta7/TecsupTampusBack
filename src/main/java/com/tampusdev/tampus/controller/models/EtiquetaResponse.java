package com.tampusdev.tampus.controller.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EtiquetaResponse {
    private int id_etiqueta;
    private String nombre;
}

package com.tampusdev.tampus.controller.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioEtiquetaResponse {

    private int id;
    private Integer id_anuncio;
    private Integer id_etiqueta;

}

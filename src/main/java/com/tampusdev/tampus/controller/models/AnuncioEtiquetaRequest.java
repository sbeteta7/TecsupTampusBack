package com.tampusdev.tampus.controller.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AnuncioEtiquetaRequest {
    private Integer id_anuncio;
    private List<Integer> id_etiquetas;
}

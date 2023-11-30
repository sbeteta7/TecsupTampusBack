package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.Etiqueta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioEtiquetaRequest {
    private Integer id_anuncio;
    private List<Integer> id_etiquetas;
}

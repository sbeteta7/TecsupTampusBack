package com.tampusdev.tampus.controller.models;

import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.Etiqueta;
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
    private int id_anuncio;
    private int id_etiqueta;

}

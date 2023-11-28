package com.tampusdev.tampus.services.businesslogic;


import com.tampusdev.tampus.controller.models.AnuncioEtiquetaRequest;
import com.tampusdev.tampus.controller.models.AnuncioEtiquetaResponse;
import com.tampusdev.tampus.persistence.entities.AnuncioEtiqueta;
import com.tampusdev.tampus.persistence.repository.AnuncioEtiquetaRepository;
import com.tampusdev.tampus.services.AnuncioEtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnuncioEtiquetaServicelmpl implements AnuncioEtiquetaService {


    private final AnuncioEtiquetaRepository anuncioEtiquetaRepository;
    public List<AnuncioEtiquetaResponse> associateAnuncioEtiquetas(AnuncioEtiquetaRequest request) {
        List<AnuncioEtiqueta> anuncioEtiquetas = new ArrayList<>();
        for (Integer idEtiqueta : request.getId_etiquetas()) {
            var anuncioEtiqueta = AnuncioEtiqueta.builder()
                    .id_anuncio(request.getId_anuncio())
                    .id_etiqueta(idEtiqueta)
                    .build();
            anuncioEtiquetas.add(anuncioEtiqueta);
        }

        anuncioEtiquetaRepository.saveAll(anuncioEtiquetas);

        List<AnuncioEtiquetaResponse> anuncioEtiquetaResponses = new ArrayList<>();
        for (AnuncioEtiqueta anuncioEtiqueta : anuncioEtiquetas) {
            anuncioEtiquetaResponses.add(AnuncioEtiquetaResponse.builder()
                    .id(anuncioEtiqueta.getId())
                    .id_anuncio(anuncioEtiqueta.getId_anuncio())
                    .id_etiqueta(anuncioEtiqueta.getId_etiqueta())
                    .build());
        }

        return anuncioEtiquetaResponses;
    }


}


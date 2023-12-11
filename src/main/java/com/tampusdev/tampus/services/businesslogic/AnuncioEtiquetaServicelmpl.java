package com.tampusdev.tampus.services.businesslogic;


import com.tampusdev.tampus.controller.models.AnuncioEtiquetaRequest;
import com.tampusdev.tampus.controller.models.AnuncioEtiquetaResponse;
import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.persistence.entities.Etiqueta;
import com.tampusdev.tampus.persistence.entities.Anuncio;
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
            Anuncio anuncio = new Anuncio();
            anuncio.setId_anuncio(request.getId_anuncio());

            Etiqueta etiqueta = new Etiqueta();
            etiqueta.setId_etiqueta(idEtiqueta);
            var anuncioEtiqueta = AnuncioEtiqueta.builder()
                    .id_anuncio(anuncio)
                    .id_etiqueta(etiqueta)
                    .build();
            anuncioEtiquetas.add(anuncioEtiqueta);
        }
        anuncioEtiquetaRepository.saveAll(anuncioEtiquetas);
        List<AnuncioEtiquetaResponse> anuncioEtiquetaResponses = new ArrayList<>();
        for (AnuncioEtiqueta anuncioEtiqueta : anuncioEtiquetas) {
            anuncioEtiquetaResponses.add(AnuncioEtiquetaResponse.builder()
                    .id(anuncioEtiqueta.getId())
                    .id_anuncio(anuncioEtiqueta.getId_anuncio().getId_anuncio())
                    .id_etiqueta(anuncioEtiqueta.getId_etiqueta().getId_etiqueta())
                    .build());
        }

        return anuncioEtiquetaResponses;
    }

    public List<EtiquetaResponse> getEtiquetaByAnuncio(Integer id_anuncio) {

        List<AnuncioEtiqueta> anuncioEtiquetas = anuncioEtiquetaRepository.findById_anuncio(id_anuncio);
        List<EtiquetaResponse> etiquetaResponses = new ArrayList<>();
        for (AnuncioEtiqueta anuncioEtiqueta : anuncioEtiquetas) {
            etiquetaResponses.add(EtiquetaResponse.builder()
                    .id_etiqueta(anuncioEtiqueta.getId_etiqueta().getId_etiqueta())
                    .nombre(anuncioEtiqueta.getId_etiqueta().getNombre())
                    .build());
        }
        return etiquetaResponses;
    }

}


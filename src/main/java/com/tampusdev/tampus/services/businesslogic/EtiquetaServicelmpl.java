package com.tampusdev.tampus.services.businesslogic;


import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.persistence.entities.Etiqueta;
import com.tampusdev.tampus.persistence.repository.EtiquetaRepository;
import com.tampusdev.tampus.services.EtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtiquetaServicelmpl implements EtiquetaService {
    private final EtiquetaRepository etiquetaRepository;
    @Override
    public List<EtiquetaResponse> getAllEtiquetas() {
        List<Etiqueta> etiquetas = etiquetaRepository.findAll();
        List<EtiquetaResponse> etiquetaResponses = new ArrayList<>();
        for (Etiqueta etiqueta : etiquetas) {
            EtiquetaResponse etiquetaResponse = new EtiquetaResponse();
            etiquetaResponse.setId_etiqueta(etiqueta.getId_etiqueta());
            etiquetaResponse.setNombre(etiqueta.getNombre());
            etiquetaResponses.add(etiquetaResponse);
        }
        return etiquetaResponses;
    }

}

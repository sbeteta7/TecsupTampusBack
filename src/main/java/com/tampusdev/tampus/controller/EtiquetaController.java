package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.services.EtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/etiquetas/publicar")
@RequiredArgsConstructor
public class EtiquetaController {
    @Autowired
    private  EtiquetaService etiquetaService;
    @GetMapping("/getAll")
    public ResponseEntity<List<EtiquetaResponse>> getAllEtiquetas() {
        try {
            List<EtiquetaResponse> etiquetasResponses = etiquetaService.getAllEtiquetas();
            return ResponseEntity.ok(etiquetasResponses);
        } catch (Exception e) {
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al recuperar los anuncios: " + e.getMessage());
        }
    }
}

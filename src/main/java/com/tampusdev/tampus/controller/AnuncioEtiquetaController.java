package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.AnuncioEtiquetaRequest;
import com.tampusdev.tampus.controller.models.AnuncioEtiquetaResponse;
import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.services.AnuncioEtiquetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/anuncioEtiquetas")
@RequiredArgsConstructor
public class AnuncioEtiquetaController {
    @Autowired
    private AnuncioEtiquetaService anuncioEtiquetaService;

    @PostMapping("/associate")
    public ResponseEntity<List<AnuncioEtiquetaResponse>> associateAnuncioEtiquetas(@RequestBody AnuncioEtiquetaRequest request
    ) {
        try {
            return ResponseEntity.ok(anuncioEtiquetaService.associateAnuncioEtiquetas(request));
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }

    @GetMapping("/getEtiquetaByAnuncio/{id_anuncio}")
    public ResponseEntity<List<EtiquetaResponse>> getEtiquetaByAnuncio(@PathVariable Integer id_anuncio) {
        try {
            return ResponseEntity.ok(anuncioEtiquetaService.getEtiquetaByAnuncio(id_anuncio));
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }
}
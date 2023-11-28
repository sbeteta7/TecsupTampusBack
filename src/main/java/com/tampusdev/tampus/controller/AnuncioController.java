package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.services.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/anuncios")
@RequiredArgsConstructor
public class AnuncioController {
    @Autowired
    private AnuncioService anuncioService;

    @PostMapping("/store")
    public ResponseEntity<AnuncioResponse> createAnuncio(@RequestBody AnuncioRequest request
    ) {
        try {
            return ResponseEntity.ok(anuncioService.createAnuncio(request));
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AnuncioResponse>> getAllAnuncios() {
        try {
            List<AnuncioResponse> anunciosResponses = anuncioService.getAllAnuncios();
            return ResponseEntity.ok(anunciosResponses);
        } catch (Exception e) {
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al recuperar los anuncios: " + e.getMessage());
        }
    }
}

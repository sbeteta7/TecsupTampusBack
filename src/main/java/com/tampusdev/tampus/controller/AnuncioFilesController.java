package com.tampusdev.tampus.controller;


import com.tampusdev.tampus.controller.models.*;
import com.tampusdev.tampus.services.AnuncioFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anuncioFiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AnuncioFilesController {
    @Autowired
    private AnuncioFilesService anuncioFilesService;

    @PostMapping("/associate")
    public ResponseEntity<List<AnuncioFilesResponse>> associateAnuncioFiles(@RequestBody AnuncioFilesRequest request
    ) {
        try {
            return ResponseEntity.ok(anuncioFilesService.associateAnuncioFiles(request));
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }

    @GetMapping("/getFilesByAnuncio/{id_anuncio}")
    public ResponseEntity<List<FileUploadResponse>> getEtiquetaByAnuncio(@PathVariable Integer id_anuncio) {
        try {
            return ResponseEntity.ok(anuncioFilesService.getFilesByAnuncio(id_anuncio));
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al guardar el curso: " + e.getMessage());
        }
    }

}

package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.services.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/usuario/{idAnuncio}")
    public ResponseEntity<String> getUsuarioByAnuncio(@PathVariable Long idAnuncio) {
        Optional<String> nombreApellido = anuncioService.getUsuarioByAnuncio(Math.toIntExact(idAnuncio));

        if (nombreApellido.isPresent()) {
            return ResponseEntity.ok(nombreApellido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
}

    @GetMapping("/getByUser/{idUsuario}")
    public ResponseEntity<List<AnuncioResponse>> getAnunciosByUsuario(@PathVariable Integer idUsuario) {
        try {
            List<AnuncioResponse> anunciosResponses = anuncioService.getAnunciosByUsuario(idUsuario);
            return ResponseEntity.ok(anunciosResponses);
        } catch (Exception e) {
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al recuperar los anuncios: " + e.getMessage());
        }
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<AnuncioResponse>> getAnunciosFiltrados(
            @RequestParam(name = "precioMin", required = false) BigDecimal precioMin,
            @RequestParam(name = "precioMax", required = false) BigDecimal precioMax,
            @RequestParam(name = "tipoEspacio", required = false) String tipoEspacio,
            @RequestParam(name = "numHab", required = false, defaultValue = "0") int numHab,
            @RequestParam(name = "numCama", required = false, defaultValue = "0") int numCama,
            @RequestParam(name = "dimensiones", required = false) Integer dimensiones
    ) {
        List<AnuncioResponse> anuncios = anuncioService.getAnunciosConFiltros(precioMin, precioMax, tipoEspacio, numHab, numCama, dimensiones);
        return ResponseEntity.ok(anuncios);
    }





}

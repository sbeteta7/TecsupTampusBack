package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.controller.models.UsuarioRequest;
import com.tampusdev.tampus.controller.models.UsuarioResponse;
import com.tampusdev.tampus.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/getUserByEmail")
    public ResponseEntity<UsuarioResponse> findUsuarioByEmail(String email) {
        try {
            UsuarioResponse usuarioResponse = usuarioService.findUsuarioByEmail(email);
            return ResponseEntity.ok(usuarioResponse);
        } catch (Exception e) {
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al recuperar los anuncios: " + e.getMessage());
        }
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UsuarioResponse> findUsuarioById(@PathVariable Integer id) {
        try {
            UsuarioResponse usuarioResponse = usuarioService.findUsuarioById(id);
            return ResponseEntity.ok(usuarioResponse);
        } catch (Exception e) {
            e.printStackTrace();  // Agregar manejo de errores adecuado
            throw new RuntimeException("Error al recuperar los anuncios: " + e.getMessage());
        }
    }
}

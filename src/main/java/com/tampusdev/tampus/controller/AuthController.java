package com.tampusdev.tampus.controller;

import com.tampusdev.tampus.controller.models.AuthResponse;
import com.tampusdev.tampus.controller.models.AuthenticationRequest;
import com.tampusdev.tampus.controller.models.RegisterRequest;
import com.tampusdev.tampus.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register-estudiante")
    public ResponseEntity<AuthResponse> registerEstudiante(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registerEstudiante(request));
    }

    @PostMapping("/register-anfitrion")
    public ResponseEntity<AuthResponse> registerAnfitrion(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.registerAnfitrion(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthenticationRequest request ){
        return ResponseEntity.ok(authService.authenticate(request));
    }

}

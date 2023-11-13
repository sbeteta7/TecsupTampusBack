package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.AuthResponse;
import com.tampusdev.tampus.controller.models.AuthenticationRequest;
import com.tampusdev.tampus.controller.models.RegisterRequest;

public interface AuthService {
    AuthResponse registerEstudiante (RegisterRequest request);
    AuthResponse authenticate (AuthenticationRequest request);

    AuthResponse registerAnfitrion(RegisterRequest request);
}

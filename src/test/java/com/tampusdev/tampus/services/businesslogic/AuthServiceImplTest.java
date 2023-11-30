package com.tampusdev.tampus.services.businesslogic;

import com.tampusdev.tampus.controller.models.AuthResponse;
import com.tampusdev.tampus.controller.models.AuthenticationRequest;
import com.tampusdev.tampus.controller.models.RegisterRequest;
import com.tampusdev.tampus.persistence.enums.RoleEnum;
import com.tampusdev.tampus.persistence.entities.Usuario;
import com.tampusdev.tampus.persistence.repository.UserRepository;
import com.tampusdev.tampus.config.security.JwtService;
import com.tampusdev.tampus.services.businesslogic.AuthServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthServiceImpl authService;


    @Test
    void registerEstudiante_ShouldReturnAuthToken() {
        // Arrange
        RegisterRequest request = new RegisterRequest("Marcelo", "Gavilan", "marcelo.gavilan@example.com", "password123");
        Usuario mockUser = Usuario.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleEnum.ROLE_ESTUDIANTE)
                .build();
        when(userRepository.save(any(Usuario.class))).thenReturn(mockUser);
        when(jwtService.generateToken(any(Usuario.class))).thenReturn("mockedToken");

        // Act
        AuthResponse response = authService.registerEstudiante(request);

        // Assert
        assertEquals("mockedToken", response.getToken());
    }

    @Test
    void authenticate_ShouldReturnAuthToken() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest("john.doe@example.com", "password123");
        Usuario mockUser = Usuario.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("encodedPassword")
                .role(RoleEnum.ROLE_ESTUDIANTE)
                .build();

        when(userRepository.findByEmail(any(String.class))).thenReturn(Optional.of(mockUser));
        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(mockAuthentication());
        when(jwtService.generateToken(any(Usuario.class))).thenReturn("mockedToken");

        // Act
        AuthResponse response = authService.authenticate(request);

        // Assert
        assertEquals("mockedToken", response.getToken());
    }

    private Authentication mockAuthentication() {
        return new UsernamePasswordAuthenticationToken("john.doe@example.com", "password123");
    }
}


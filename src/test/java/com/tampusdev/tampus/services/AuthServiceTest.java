package com.tampusdev.tampus.services;

import com.tampusdev.tampus.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void registerEstudiante() {
    }

    @Test
    void authenticate() {
    }

    @Test
    void registerAnfitrion() {
    }
}
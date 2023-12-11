package com.tampusdev.tampus.utils;

import com.tampusdev.tampus.controller.models.RegisterRequest;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

    public boolean isValidRegisterRequest(RegisterRequest request) {
        if (request == null) {
            return false;
        }
        if (StringUtils.isBlank(request.getFirstName()) || StringUtils.isBlank(request.getLastName())
                || StringUtils.isBlank(request.getEmail()) || StringUtils.isBlank(request.getPassword())
                || request.getFecha_nacimiento() == null || StringUtils.isBlank(request.getTelefono())) {
            return false;
        }
        if (!isStrongPassword(request.getPassword())) {
            return false;
        }
        if (!isValidPeruvianPhoneNumber(request.getTelefono())) {
            return false;
        }
        return true;
    }

    private boolean isStrongPassword(String password) {
        int minLength = 8;
        if (password.length() < minLength) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()-_=+{};:,<.>/?].*")) {
            return false;
        }
        return true;
    }

    private boolean isValidPeruvianPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 9) {
            return false;
        }

        if (!phoneNumber.startsWith("9")) {
            return false;
        }
        return true;
    }
}
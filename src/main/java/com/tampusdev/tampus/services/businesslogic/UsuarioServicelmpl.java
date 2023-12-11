package com.tampusdev.tampus.services.businesslogic;

import com.tampusdev.tampus.controller.models.UsuarioResponse;
import com.tampusdev.tampus.persistence.entities.Usuario;
import com.tampusdev.tampus.persistence.repository.UserRepository;
import com.tampusdev.tampus.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServicelmpl implements UsuarioService {
    private final UserRepository userRepository;


    @Override
    public UsuarioResponse findUsuarioByEmail(String email) {
        Optional<Usuario> usuario = userRepository.findByEmail(email);

        if (!usuario.isPresent()) {
            return null;
        }else {
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setId(usuario.get().getId());
            usuarioResponse.setFirstName(usuario.get().getFirstName());
            usuarioResponse.setLastName(usuario.get().getLastName());
            usuarioResponse.setEmail(usuario.get().getEmail());
            usuarioResponse.setRole(String.valueOf(usuario.get().getRole()));
            return usuarioResponse;
        }
    }

    @Override
    public UsuarioResponse findUsuarioById(Integer id) {
        Optional<Usuario> usuario = userRepository.findById(id);

        if (!usuario.isPresent()) {
            return null;
        }else {
            UsuarioResponse usuarioResponse = new UsuarioResponse();
            usuarioResponse.setId(usuario.get().getId());
            usuarioResponse.setFirstName(usuario.get().getFirstName());
            usuarioResponse.setLastName(usuario.get().getLastName());
            usuarioResponse.setEmail(usuario.get().getEmail());
            usuarioResponse.setRole(String.valueOf(usuario.get().getRole()));
            return usuarioResponse;
        }
    }
}

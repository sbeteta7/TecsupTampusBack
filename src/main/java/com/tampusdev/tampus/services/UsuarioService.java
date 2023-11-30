package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.RegisterRequest;
import com.tampusdev.tampus.controller.models.UsuarioRequest;
import com.tampusdev.tampus.controller.models.UsuarioResponse;
import com.tampusdev.tampus.persistence.entities.Usuario;

public interface UsuarioService {
     UsuarioResponse findUsuarioByEmail(String email);

     UsuarioResponse findUsuarioById(Integer id);



}
